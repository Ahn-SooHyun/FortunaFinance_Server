package kr.co.FortunaFinance_Server.controller.etc;

import kr.co.FortunaFinance_Server.Service.etc.ETCServiceImpl;
import kr.co.FortunaFinance_Server.Util.Base64Util;
import kr.co.FortunaFinance_Server.Util.ResponsData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/etc")
public class HeaderController {

    Logger logger = LoggerFactory.getLogger(HeaderController.class);

    @Autowired
    private ETCServiceImpl etcServiceImpl;

    @GetMapping("/name")
    public ResponseEntity<?> ID_Check(@RequestParam String uuid) {
        ResponsData data = new ResponsData();
        Base64Util base = new Base64Util();


        int IDX = etcServiceImpl.uuidCheck(uuid);
        if (IDX == -1) {
            data.setCode("401");
            data.setMessage("UUID does not exist.");
            return ResponseEntity.ok(data);
        }
        if (IDX == 0) {
            data.setCode("402");
            data.setMessage("Your time has expired.");
            return ResponseEntity.ok(data);
        }

        etcServiceImpl.uuidDateUpdate(uuid);
        String result = etcServiceImpl.getName(IDX);
        data.setData(result);

        return ResponseEntity.ok(data);
    }
}
