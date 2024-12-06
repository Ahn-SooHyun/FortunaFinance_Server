package kr.co.FortunaFinance_Server.DTO.notice;

import lombok.Data;

@Data
public class NoticeadditionReq {


    private String uuid;

    private int useridx;

    private String category;
    private String title;
    private String content;

}
