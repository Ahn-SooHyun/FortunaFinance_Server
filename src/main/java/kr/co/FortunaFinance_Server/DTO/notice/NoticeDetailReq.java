package kr.co.FortunaFinance_Server.DTO.notice;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NoticeDetailReq {


    @NotBlank(message = "uuid null")
    private String uuid;

    @NotBlank(message = "noticeIndex null")
    private int noticeIndex;
}
