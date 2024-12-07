package kr.co.FortunaFinance_Server.DTO.notice;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class NoticeadditionReq {


    @NotBlank(message = "uuid null")
    private String uuid;

    private int useridx;

    @NotBlank(message = "category cannot be empty.")
    @Size(min = 2, max = 30, message = "category must be between 8 and 30 characters.")
    private String category;
    @NotBlank(message = "title cannot be empty.")
    @Size(min = 5, max = 100000, message = "title must be between 1 and 100000 characters.")
    private String title;
    @NotBlank(message = "content cannot be empty.")
    @Size(min = 5, max = 1000000000, message = "content must be between 1 and 1000000000 characters.")
    private String content;

}
