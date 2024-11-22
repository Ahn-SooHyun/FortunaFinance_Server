package kr.co.FortunaFinance_Server.controller.user;


import jakarta.validation.Valid;
import kr.co.FortunaFinance_Server.DTO.LoginRegister.LoginReq;
import kr.co.FortunaFinance_Server.DTO.LoginRegister.RegisterReq;
import kr.co.FortunaFinance_Server.Service.LoginRegister.RegisterServiceImpl;
import kr.co.FortunaFinance_Server.Util.BCryptService;
import kr.co.FortunaFinance_Server.Util.Base64Util;
import kr.co.FortunaFinance_Server.Util.ResponsData;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login-register")
public class LoginRegisterController {

    Logger logger = LoggerFactory.getLogger(LoginRegisterController.class);

    @Autowired
    private RegisterServiceImpl registerservice;
//    @Autowired
//    private RegisterVal registerVal;  // RegisterVal 클래스를 직접 사용


    /**
     * Checks if the provided ID exists in the system.
     * The method encodes the ID using Base64 encoding and checks against the stored IDs.
     *
     * @param ID the ID to be checked
     * @return a ResponseEntity containing a ResponsData object with the check result
     */
    @GetMapping("/idCheck")
    public ResponseEntity<?> ID_Check(@RequestParam String ID) {
        ResponsData data = new ResponsData();
        Base64Util base = new Base64Util();

        String encodedID = base.encode(ID);
        if (encodedID.equals(registerservice.ID_Check(encodedID))) {
            data.setCode("201");
        }

        return ResponseEntity.ok(data);
    }

    /**
     * Registers a new user with the provided registration request data.
     * The method encodes the user ID using Base64 encoding, checks for ID validity,
     * encrypts the password, and then attempts to register the user.
     *
     * @param registerReq the registration request data containing user details
     * @return a ResponseEntity containing a ResponsData object with the registration result
     * @throws ParseException if there is an error parsing the date fields in the request
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterReq registerReq) throws ParseException {
        ResponsData data = new ResponsData();
        BCryptService bCrypt = new BCryptService();
        Base64Util base = new Base64Util();

        String encodedID = base.encode(registerReq.getId());
        registerReq.setId(encodedID);
        if (registerReq.getId().equals(registerservice.ID_Check(registerReq.getId()))) {
            data.setCode("400");
            data.setMessage("Invalid ID.");
            return ResponseEntity.badRequest().body(data);
        }

//        // 주소 유효성 검사 직접 호출
//        boolean isAddressValid = registerVal.validateAddress(registerReq.getAddress(), registerReq.getPostcode());
//        if (!isAddressValid) {
//            data.setCode("400");
//            data.setMessage("Invalid address or postcode.");
//            return ResponseEntity.badRequest().body(data);
//        }


        // 비밀번호 암호화
        String encodingPW = bCrypt.setPassword(registerReq.getPw());
        registerReq.setPw(encodingPW);

        int result = registerservice.register(registerReq);
        if (result == 0) {
            data.setCode("400");
            data.setMessage("Register Failed.");
        }
        System.out.println(result);

        return ResponseEntity.ok(data);
    }

    /**
     * Handles the login request by encoding the user's ID using Base64
     * and processing the login through the register service.
     *
     * @param loginReq the login request containing the user's ID and password
     * @return a ResponseEntity containing a ResponsData object with the login result, including a UUID if successful
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginReq loginReq) {
        ResponsData data = new ResponsData();
        Base64Util base = new Base64Util();

        String encodedBaseID = base.encode(loginReq.getId());
        loginReq.setId(encodedBaseID);

        String uuid = registerservice.login(loginReq);

        data.setData(uuid);

        return ResponseEntity.ok(data);
    }

}
