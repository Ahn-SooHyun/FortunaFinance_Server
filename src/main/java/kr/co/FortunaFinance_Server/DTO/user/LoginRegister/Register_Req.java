package kr.co.FortunaFinance_Server.DTO.user.LoginRegister;

import lombok.Data;

@Data
public class Register_Req {

    private String ID;
    private String PW;
    private String Name;
    private String Birth;
    private String Gender;
    private String Phone;
    private String Email;
    private String Postcode;
    private String Address;
    private String DetailAddress;

}
