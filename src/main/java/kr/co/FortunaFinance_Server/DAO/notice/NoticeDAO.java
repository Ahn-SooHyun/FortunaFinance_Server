package kr.co.FortunaFinance_Server.DAO.notice;

import kr.co.FortunaFinance_Server.DTO.notice.NoticeadditionReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeDAO {
    int Notice_addition(NoticeadditionReq noticeadditionReq);
}
