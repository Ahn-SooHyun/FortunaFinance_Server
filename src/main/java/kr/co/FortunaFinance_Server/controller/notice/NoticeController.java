package kr.co.FortunaFinance_Server.controller.notice;

import jakarta.validation.Valid;
import kr.co.FortunaFinance_Server.DTO.LoginRegister.RegisterReq;
import kr.co.FortunaFinance_Server.DTO.notice.NoticeListReq;
import kr.co.FortunaFinance_Server.DTO.notice.NoticeadditionReq;
import kr.co.FortunaFinance_Server.Service.notice.NoticeServiceImpl;
import kr.co.FortunaFinance_Server.Service.etc.ETCServiceImpl;
import kr.co.FortunaFinance_Server.Util.ResponsData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notice")
public class NoticeController {

    Logger logger = LoggerFactory.getLogger(NoticeController.class);

    @Autowired
    private NoticeServiceImpl noticeService;
    @Autowired
    private ETCServiceImpl etcService;

    @PostMapping("/addition")
    public ResponseEntity<?> addition(@RequestBody @Valid NoticeadditionReq noticeadditionReq) {
        logger.info(noticeadditionReq.toString());
        ResponsData data = new ResponsData();
        int IDX = etcService.uuidCheck(noticeadditionReq.getUuid());
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
        etcService.uuidDateUpdate(noticeadditionReq.getUuid());

        noticeadditionReq.setUseridx(IDX);


        int result = noticeService.Notice_addition(noticeadditionReq);

        if (result == 0) {
            data.setCode("400");
            data.setMessage("Your time has expired.");
        }

        return ResponseEntity.ok(data);
    }

    @GetMapping("/list")
    public ResponseEntity<?> list(@RequestBody @Valid NoticeListReq noticeListReq) {
        ResponsData data = new ResponsData();
        int IDX = etcService.uuidCheck(noticeListReq.getUuid());
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
        etcService.uuidDateUpdate(noticeListReq.getUuid());



        return ResponseEntity.ok(data);
    }

}
