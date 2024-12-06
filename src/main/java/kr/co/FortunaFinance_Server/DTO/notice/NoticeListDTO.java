package kr.co.FortunaFinance_Server.DTO.notice;

import lombok.Data;

import java.util.Date;

@Data
public class NoticeListDTO {
    private int noticeIndex;
    private String category;
    private String title;
    private String content;
    private String userIdx;
    private Date userDate;
    private int good;

}
