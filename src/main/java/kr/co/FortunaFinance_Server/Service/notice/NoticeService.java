package kr.co.FortunaFinance_Server.Service.notice;

import kr.co.FortunaFinance_Server.DTO.notice.*;

import java.util.List;

public interface NoticeService {

    int Notice_addition(NoticeadditionReq boardadditionReq);

    List<NoticeListDTO> Notice_list(NoticeListReq boardlistReq);

    NoticeDetailDTO Notice_Detail(NoticeDetailReq noticeDetailReq);
}
