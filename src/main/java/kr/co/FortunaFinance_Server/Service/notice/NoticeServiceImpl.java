package kr.co.FortunaFinance_Server.Service.notice;

import kr.co.FortunaFinance_Server.DAO.etc.ETCDAO;
import kr.co.FortunaFinance_Server.DAO.notice.NoticeDAO;
import kr.co.FortunaFinance_Server.DAO.user.LoginRegisterDAO;
import kr.co.FortunaFinance_Server.DTO.etc.UserNameListDTO;
import kr.co.FortunaFinance_Server.DTO.notice.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

    @Autowired
    private NoticeDAO noticeDAO;
    @Autowired
    private ETCDAO etcdao;

    @Override
    public int Notice_addition(NoticeadditionReq noticeadditionReq) {

        return noticeDAO.Notice_addition(noticeadditionReq);
    }

    @Override
    public List<NoticeListDTO> Notice_list(NoticeListReq noticeListReq) {

        List<UserNameListDTO> userNameListDTO = etcdao.User_Name_List();
        List<NoticeListDTO> noticeListDTO = noticeDAO.Notice_List(noticeListReq);

        for (int i = 0; i < noticeListDTO.size(); i++) {
            for (int j = 0; j < userNameListDTO.size(); j++) {
                if (noticeListDTO.get(i).getUserIdx().equals(String.valueOf(userNameListDTO.get(j).getUserIdx()))) {
                    noticeListDTO.get(i).setUserIdx(userNameListDTO.get(j).getName());
                    break;
                }
            }
        }

        return noticeListDTO;
    }

    @Override
    public NoticeDetailDTO Notice_Detail(NoticeDetailReq noticeDetailReq) {
        List<UserNameListDTO> userNameListDTO = etcdao.User_Name_List();
        NoticeDetailDTO noticeDetailDTO = noticeDAO.Notice_List(noticeListReq);

        for (int i = 0; i < userNameListDTO.size(); i++) {
            if (noticeDetailDTO.getUserIdx().equals(userNameListDTO.get(i).getUserIdx())) {
                noticeDetailDTO.setUserIdx(userNameListDTO.get(i).getName());
                break;
            }
        }

        return noticeDetailDTO;
    }
}
