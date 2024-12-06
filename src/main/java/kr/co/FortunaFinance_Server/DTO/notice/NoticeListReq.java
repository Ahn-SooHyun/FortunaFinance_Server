package kr.co.FortunaFinance_Server.DTO.notice;

import lombok.Data;

@Data
public class NoticeListReq {
    private String uuid;
    private String category;
    private String title;
}
