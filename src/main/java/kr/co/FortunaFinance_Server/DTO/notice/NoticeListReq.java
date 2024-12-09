package kr.co.FortunaFinance_Server.DTO.notice;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NoticeListReq {

    @NotBlank(message = "uuid null")
    private String uuid;
    private String category;
    private String title;
    private String user;
}
