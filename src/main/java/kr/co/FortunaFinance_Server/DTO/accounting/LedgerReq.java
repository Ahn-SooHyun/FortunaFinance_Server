package kr.co.FortunaFinance_Server.DTO.accounting;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class LedgerReq {

    private String uuid;
    private String category;
    private String paymentSelect;
    private String accountName;
    private String project;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private String traderName;

}
