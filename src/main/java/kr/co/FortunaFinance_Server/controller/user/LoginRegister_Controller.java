package kr.co.FortunaFinance_Server.controller.user;


import kr.co.FortunaFinance_Server.DTO.user.LoginRegister.Register_Req;
import kr.co.FortunaFinance_Server.Service.LoginRegister.Register_ServiceImpl;
import kr.co.FortunaFinance_Server.Util.ResponsData;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Login_Register")
public class LoginRegister_Controller {

    @Autowired
    private Register_ServiceImpl register_service;

    @GetMapping("/ID_Check")
    public ResponseEntity<?> ID_Check(@RequestParam String ID) {
        ResponsData data = new ResponsData();

        if (ID.equals(register_service.ID_Check(ID))) {
            data.setCode("201");
        }

        return ResponseEntity.ok(data);
    }

    @GetMapping("/Register")
    public ResponseEntity<?> Register(@ModelAttribute Register_Req register_req) {
        ResponsData data = new ResponsData();



        

        return ResponseEntity.ok(data);
    }
}
