package kr.co.FortunaFinance_Server.controller.accounting;

import kr.co.FortunaFinance_Server.DTO.accounting.LedgerAdditional;
import kr.co.FortunaFinance_Server.DTO.accounting.LedgerReq;
import kr.co.FortunaFinance_Server.DTO.accounting.LedgerDel;
import kr.co.FortunaFinance_Server.Service.accounting.AccountingServiceImpl;
import kr.co.FortunaFinance_Server.Service.etc.ETCServiceImpl;
import kr.co.FortunaFinance_Server.Util.ResponsData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounting")
public class AccountingController {

    Logger logger = LoggerFactory.getLogger(AccountingController.class);

    @Autowired
    private ETCServiceImpl etcServiceImpl;
    @Autowired
    private AccountingServiceImpl accountingServiceImpl;

    @GetMapping("/option/account")
    public ResponseEntity<?> optionaccount(@RequestParam String uuid) {
        ResponsData data = new ResponsData();
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

        data.setData(accountingServiceImpl.getAccountList());

        return ResponseEntity.ok(data);
    }

    @GetMapping("/option/project")
    public ResponseEntity<?> optionproject(@RequestParam String uuid) {
        ResponsData data = new ResponsData();
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

        data.setData(accountingServiceImpl.getProjectList());

        return ResponseEntity.ok(data);
    }

    @GetMapping("/option/payment")
    public ResponseEntity<?> optionpayment(@RequestParam String uuid) {
        ResponsData data = new ResponsData();
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

        data.setData(accountingServiceImpl.getPaymentList());

        return ResponseEntity.ok(data);
    }

    @GetMapping("/ledger")
    public ResponseEntity<?> ledger(@ModelAttribute LedgerReq ledgerReq) {
        ResponsData data = new ResponsData();
        int IDX = etcServiceImpl.uuidCheck(ledgerReq.getUuid());
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
        etcServiceImpl.uuidDateUpdate(ledgerReq.getUuid());

        if (ledgerReq.getTraderName() != "") {
            ledgerReq.setTraderName("%" + ledgerReq.getTraderName() + "%");
        }

        data.setData(accountingServiceImpl.getLedgerList(ledgerReq));

        return ResponseEntity.ok(data);
    }

    @GetMapping("/delete")
    public ResponseEntity<?> delete(@ModelAttribute LedgerDel ledgerdel) {
        ResponsData data = new ResponsData();
        int IDX = etcServiceImpl.uuidCheck(ledgerdel.getUuid());
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

        int result = accountingServiceImpl.updateDel(ledgerdel);
        logger.info(String.valueOf(result));

        if (result == 0) {
            data.setCode("401");
            data.setMessage("Delete failed.");
            return ResponseEntity.ok(data);
        }

        return ResponseEntity.ok(data);
    }

    @GetMapping("/ledger/additional")
    public ResponseEntity<?> additional(@ModelAttribute LedgerAdditional ledgerAdditional) {
        ResponsData data = new ResponsData();
        int IDX = etcServiceImpl.uuidCheck(ledgerAdditional.getUuid());
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
        ledgerAdditional.setUseridx(IDX);
        etcServiceImpl.uuidDateUpdate(ledgerAdditional.getUuid());

        ledgerAdditional.setTotalAmount(
                ledgerAdditional.getSupplyprice() + ledgerAdditional.getSupplyprice() / 100 * ledgerAdditional.getSurtax()
        );

        logger.info(ledgerAdditional.toString());

        accountingServiceImpl.insertLedger(ledgerAdditional);

        return ResponseEntity.ok(data);
    }
}
