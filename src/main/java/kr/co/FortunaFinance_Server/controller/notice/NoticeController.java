package kr.co.FortunaFinance_Server.controller.notice;

import jakarta.validation.Valid;
import kr.co.FortunaFinance_Server.DTO.notice.*;
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
    public ResponseEntity<?> addition(@RequestBody @Valid NoticeAdditionReq noticeadditionReq) {
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
    public ResponseEntity<?> list(@ModelAttribute  NoticeListReq noticeListReq) {
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

        data.setData(noticeService.Notice_list(noticeListReq));

        return ResponseEntity.ok(data);
    }

    @GetMapping("/detail")
    public ResponseEntity<?> detail(@ModelAttribute NoticeDetailReq noticeDetailReq) {
        ResponsData data = new ResponsData();
        int IDX = etcService.uuidCheck(noticeDetailReq.getUuid());
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
        etcService.uuidDateUpdate(noticeDetailReq.getUuid());

        data.setData(noticeService.Notice_Detail(noticeDetailReq));

        return ResponseEntity.ok(data);
    }

    @PostMapping("/good")
    public ResponseEntity<?> good(@RequestBody @Valid NoticeGoodReq noticeGoodReq) {
        ResponsData data = new ResponsData();
        int IDX = etcService.uuidCheck(noticeGoodReq.getUuid());
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
        etcService.uuidDateUpdate(noticeGoodReq.getUuid());

        int result = noticeService.Notice_Good(noticeGoodReq);

        if (result == 0) {
            data.setCode("403");
            data.setMessage("Your time has expired.");
        }

        data.setData(result);

        return ResponseEntity.ok(data);
    }

    @PostMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody @Valid NoticeEditReq noticeEditReq) {
        ResponsData data = new ResponsData();
        int IDX = etcService.uuidCheck(noticeEditReq.getUuid());
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
        etcService.uuidDateUpdate(noticeEditReq.getUuid());

        int result = noticeService.Notice_Edit(noticeEditReq);

        if (result == 0) {
            data.setCode("403");
            data.setMessage("Your time has expired.");
        }

        data.setData(result);

        return ResponseEntity.ok(data);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody @Valid NoticeDeleteReq noticeDeleteReq) {
        ResponsData data = new ResponsData();
        int IDX = etcService.uuidCheck(noticeDeleteReq.getUuid());
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
        etcService.uuidDateUpdate(noticeDeleteReq.getUuid());

        logger.info(noticeDeleteReq.getUuid());

        int result = noticeService.Notice_Delete(noticeDeleteReq);

        if (result == 0) {
            data.setCode("403");
            data.setMessage("Your time has expired.");
        }

        data.setData(result);

        return ResponseEntity.ok(data);
    }

}
