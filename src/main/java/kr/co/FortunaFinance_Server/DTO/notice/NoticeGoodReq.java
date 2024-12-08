package kr.co.FortunaFinance_Server.DTO.notice;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NoticeGoodReq {


    @NotBlank(message = "uuid null")
    private String uuid;

    @Min(value = 1, message = "noticeIndex must be greater than 0")  // 최소값을 1로 설정
    private int noticeIndex;
}
