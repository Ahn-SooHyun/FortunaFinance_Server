package kr.co.FortunaFinance_Server.DTO.LoginRegister;

import lombok.Data;

/**
 * Data Transfer Object (DTO) for managing user login information.
 * This class encapsulates the user's login details such as user index, password,
 * number of previous login failures (NoPF), and a universally unique identifier (UUID).
 */
@Data
public class LoginDTO {

    /**
     * Represents the unique index of the user within the system.
     * This field is used as a key identifier for the login process.
     */
    private int useridx;

    /**
     * Represents the user's password.
     * This field is used to authenticate the user's login information.
     */
    private String password;

    /**
     * Represents the number of previous login failures for the user.
     * This field is used*/
    private int nopf;

    /**
     * Represents the universally unique identifier (UUID) for the user.
     * This field is used to uniquely identify the user's session or transaction.
     */
    private String uuid;

}
