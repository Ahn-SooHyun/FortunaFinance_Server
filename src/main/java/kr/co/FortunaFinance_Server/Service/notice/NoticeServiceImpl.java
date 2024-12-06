package kr.co.FortunaFinance_Server.Service.notice;

import kr.co.FortunaFinance_Server.DAO.notice.NoticeDAO;
import kr.co.FortunaFinance_Server.DAO.user.LoginRegisterDAO;
import kr.co.FortunaFinance_Server.DTO.notice.NoticeadditionReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDAO noticeDAO;

    @Override
    public int Notice_addition(NoticeadditionReq boardadditionReq) {

        return noticeDAO.Notice_addition(boardadditionReq);
    }
}
