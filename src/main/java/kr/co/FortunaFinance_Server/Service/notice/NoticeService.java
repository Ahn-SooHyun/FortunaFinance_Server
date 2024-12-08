package kr.co.FortunaFinance_Server.Service.notice;

import kr.co.FortunaFinance_Server.DTO.notice.*;

import java.util.List;

public interface NoticeService {

    int Notice_addition(NoticeAdditionReq boardadditionReq);

    List<NoticeListDTO> Notice_list(NoticeListReq boardlistReq);

    NoticeDetailDTO Notice_Detail(NoticeDetailReq noticeDetailReq);

    int Notice_Good(NoticeGoodReq noticeGoodReq);

    int Notice_Edit(NoticeEditReq noticeEditReq);

    int Notice_Delete(NoticeDeleteReq noticeDeleteReq);
}
