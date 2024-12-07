package kr.co.FortunaFinance_Server.DAO.notice;

import kr.co.FortunaFinance_Server.DTO.notice.NoticeListDTO;
import kr.co.FortunaFinance_Server.DTO.notice.NoticeListReq;
import kr.co.FortunaFinance_Server.DTO.notice.NoticeadditionReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeDAO {
    int Notice_addition(NoticeadditionReq noticeadditionReq);

    List<NoticeListDTO> Notice_List(NoticeListReq noticeListReq);
}
