package kr.co.FortunaFinance_Server.DAO.notice;

import kr.co.FortunaFinance_Server.DTO.notice.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeDAO {
    int Notice_addition(NoticeAdditionReq noticeadditionReq);

    List<NoticeListDTO> Notice_List(NoticeListReq noticeListReq);

    NoticeDetailDTO Notice_Detail(NoticeDetailReq noticeDetailReq);

    Integer Notice_Good(NoticeGoodReq noticeGoodReq);

    Integer Notice_Edit(NoticeEditReq noticeEditReq);

    Integer Notice_Delete(NoticeDeleteReq noticeDeleteReq);
}
