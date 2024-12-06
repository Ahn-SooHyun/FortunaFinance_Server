package kr.co.FortunaFinance_Server.Service.notice;

import kr.co.FortunaFinance_Server.DTO.notice.NoticeListDTO;
import kr.co.FortunaFinance_Server.DTO.notice.NoticeListReq;
import kr.co.FortunaFinance_Server.DTO.notice.NoticeadditionReq;

public interface NoticeService {

    int Notice_addition(NoticeadditionReq boardadditionReq);

    NoticeListDTO Notice_list(NoticeListReq boardlistReq);
}
