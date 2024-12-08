package kr.co.FortunaFinance_Server.DTO.notice;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NoticeDeleteReq {


    @NotBlank(message = "uuid null")
    private String uuid;

    @NotNull(message = "noticeIndex null") // Ensure the field is not null
    @Min(value = 1, message = "noticeIndex must be greater than 0") // Additional check to ensure noticeIndex is greater than 0
    private int noticeIndex;
}
