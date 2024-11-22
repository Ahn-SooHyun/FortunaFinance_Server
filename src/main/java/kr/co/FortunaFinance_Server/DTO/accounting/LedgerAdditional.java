package kr.co.FortunaFinance_Server.DTO.accounting;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class LedgerAdditional {

    private String uuid;

    private int useridx;

    @Min(value = 1, message = "Project identifier must be greater than 0")
    private int project;

    @NotBlank(message = "Account name must not be blank")
    private String account;

    @NotBlank(message = "Category must not be blank")
    private String category;

    @Min(value = 1, message = "Account name identifier must be greater than 0")
    private int accountName;

    @NotNull(message = "Date cannot be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Min(value = 0, message = "Supply price must be zero or positive")
    private int supplyprice;

    @Min(value = 0, message = "Surtax must be zero or positive")
    private int surtax;

    private int totalAmount;

    @Min(value = 1, message = "Payment selection identifier must be greater than 0")
    private int paymentSelect;
    private String notice;

}
