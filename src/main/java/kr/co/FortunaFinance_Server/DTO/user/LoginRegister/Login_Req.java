package kr.co.FortunaFinance_Server.DTO.user.LoginRegister;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Login_Req {
    private String ID;
    private String Password;
}
