package kr.co.FortunaFinance_Server.Service.accounting;

import kr.co.FortunaFinance_Server.DAO.accounting.AccountingDAO;
import kr.co.FortunaFinance_Server.DTO.accounting.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountingServiceImpl implements AccountingService{

    Logger logger = LoggerFactory.getLogger(AccountingServiceImpl.class);

    @Autowired
    private AccountingDAO accountingDAO;

    @Override
    public List<LedgerOptionProjectDTO> getProjectList() {
        List<LedgerOptionProjectDTO> list = accountingDAO.getProjectList();

        return list;
    }

    @Override
    public List<LedgerOptionAccountDTO> getAccountList() {
        List<LedgerOptionAccountDTO> list = accountingDAO.getAccountList();

        return list;
    }

    @Override
    public List<LedgerOptionPaymentDTO> getPaymentList() {
        List<LedgerOptionPaymentDTO> list = accountingDAO.getPaymentList();

        return list;
    }

    @Override
    public List<LedgerListDTO> getLedgerList(LedgerReq ledgerReq) {
        List<LedgerListDTO> list = accountingDAO.LedgerList(ledgerReq);
        List<LedgerOptionProjectDTO> Prolist = getProjectList();
        List<LedgerOptionAccountDTO> ACClist = getAccountList();
        List<LedgerOptionPaymentDTO> paylist = getPaymentList();

        // 프로젝트 인덱스를 프로젝트 이름으로 매핑
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < Prolist.size(); j++) {
                if (list.get(i).getProjectidx().equals(Prolist.get(j).getProjectindex())) {
                    list.get(i).setProjectidx(Prolist.get(j).getProjectname());  // 여기서 set을 올바르게 사용
                }
            }
            // ACClist와 paylist 처리
            // 예시: 계좌 리스트 처리
            for (int j = 0; j < ACClist.size(); j++) {
                if (list.get(i).getAccountindex().equals(ACClist.get(j).getAccountindex())) {
                    list.get(i).setAccountindex(ACClist.get(j).getAccountname());
                }
            }
            // 예시: 결제 방식 리스트 처리
            for (int j = 0; j < paylist.size(); j++) {
                if (list.get(i).getCpindex().equals(paylist.get(j).getCpindex())) {
                    list.get(i).setCpindex(paylist.get(j).getBank() + " " + paylist.get(j).getCpnum());
                    list.get(i).setRepresentative(paylist.get(j).getRepresentative());
                }
            }
        }

        return list;
    }

    @Override
    public int updateDel(LedgerDel ledgerdel) {
        Integer check = accountingDAO.updateDel(ledgerdel.getIdx());


        return check;
    }

    @Override
    public int insertLedger(LedgerAdditional ledgeradditional) {

        return accountingDAO.insertLedger(ledgeradditional);
    }

}
