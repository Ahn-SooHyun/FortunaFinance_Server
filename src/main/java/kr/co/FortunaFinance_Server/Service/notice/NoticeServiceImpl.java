package kr.co.FortunaFinance_Server.Service.notice;

import kr.co.FortunaFinance_Server.DAO.etc.ETCDAO;
import kr.co.FortunaFinance_Server.DAO.notice.NoticeDAO;
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
    public int Notice_addition(NoticeAdditionReq noticeadditionReq) {

        return noticeDAO.Notice_addition(noticeadditionReq);
    }

    @Override
    public List<NoticeListDTO> Notice_list(NoticeListReq noticeListReq) {
        noticeListReq.setTitle("%" + noticeListReq.getTitle() + "%");

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

        logger.info(noticeListDTO.toString());

        return noticeListDTO;
    }

    @Override
    public NoticeDetailDTO Notice_Detail(NoticeDetailReq noticeDetailReq) {
        List<UserNameListDTO> userNameListDTO = etcdao.User_Name_List();
        NoticeDetailDTO noticeDetailDTO = noticeDAO.Notice_Detail(noticeDetailReq);

        for (int i = 0; i < userNameListDTO.size(); i++) {
            if (noticeDetailDTO.getUserIdx().equals(userNameListDTO.get(i).getUserIdx())) {
                noticeDetailDTO.setUserIdx(userNameListDTO.get(i).getName());
                break;
            }
        }

        return noticeDetailDTO;
    }

    @Override
    public int Notice_Good(NoticeGoodReq noticeGoodReq) {
        Integer result = noticeDAO.Notice_Good(noticeGoodReq);

        if (result == null) {
            // 적절한 예외 처리 또는 기본값 반환
            return 0; // 또는 예외를 발생시키기
        }
        return result;
    }

    @Override
    public int Notice_Edit(NoticeEditReq noticeEditReq) {
        Integer result = noticeDAO.Notice_Edit(noticeEditReq);

        if (result == null) {
            // 적절한 예외 처리 또는 기본값 반환
            return 0; // 또는 예외를 발생시키기
        }

        return result;
    }

    @Override
    public int Notice_Delete(NoticeDeleteReq noticeDeleteReq) {
        Integer result = noticeDAO.Notice_Delete(noticeDeleteReq);

        if (result == null) {
            // 적절한 예외 처리 또는 기본값 반환
            return 0; // 또는 예외를 발생시키기
        }

        return result;
    }
}
