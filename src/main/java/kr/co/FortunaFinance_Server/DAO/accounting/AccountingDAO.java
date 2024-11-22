package kr.co.FortunaFinance_Server.DAO.accounting;

import kr.co.FortunaFinance_Server.DTO.accounting.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountingDAO {

    List<LedgerOptionProjectDTO> getProjectList();

    List<LedgerOptionAccountDTO> getAccountList();

    List<LedgerOptionPaymentDTO> getPaymentList();

    List<LedgerListDTO> LedgerList(LedgerReq ledgerReq);

    Integer updateDel(int index);

    int insertLedger(LedgerAdditional ledgerAdditional);

}
