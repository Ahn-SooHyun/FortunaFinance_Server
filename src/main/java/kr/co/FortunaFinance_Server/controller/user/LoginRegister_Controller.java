package kr.co.FortunaFinance_Server.controller.user;


import kr.co.FortunaFinance_Server.Service.LoginRegister.Register_ServiceImpl;
import kr.co.FortunaFinance_Server.Util.ResponsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Login_Register")
public class LoginRegister_Controller {

    @Autowired
    private Register_ServiceImpl register_service;

    @GetMapping("/ID_Check")
    public ResponseEntity<?> ID_Check(@RequestParam String ID) {
        ResponsData data = new ResponsData();

        System.out.println("== ID_Check ==================");
        System.out.println("ID : " + ID);

        data.setData(register_service.ID_Check(ID));

        return ResponseEntity.ok(data);
    }
}
