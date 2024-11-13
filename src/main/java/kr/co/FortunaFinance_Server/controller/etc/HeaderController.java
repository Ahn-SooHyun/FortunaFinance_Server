package kr.co.FortunaFinance_Server.controller.etc;

import kr.co.FortunaFinance_Server.Util.Base64Util;
import kr.co.FortunaFinance_Server.Util.ResponsData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/etc")
public class HeaderController {

    @GetMapping("/name")
    public ResponseEntity<?> ID_Check(@RequestParam String ID) {
        ResponsData data = new ResponsData();
        Base64Util base = new Base64Util();

        return ResponseEntity.ok(data);
    }
}
