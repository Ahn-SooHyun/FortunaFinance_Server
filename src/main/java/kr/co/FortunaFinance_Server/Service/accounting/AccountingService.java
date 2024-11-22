package kr.co.FortunaFinance_Server.Service.accounting;

import kr.co.FortunaFinance_Server.DTO.accounting.*;

import java.util.List;

public interface AccountingService {

    List<LedgerOptionProjectDTO> getProjectList();

    List<LedgerOptionAccountDTO> getAccountList();

    List<LedgerOptionPaymentDTO> getPaymentList();

    List<LedgerListDTO> getLedgerList(LedgerReq ledgerReq);

    int updateDel(LedgerDel ledgerdel);

    int insertLedger(LedgerAdditional ledgeradditional);
}
