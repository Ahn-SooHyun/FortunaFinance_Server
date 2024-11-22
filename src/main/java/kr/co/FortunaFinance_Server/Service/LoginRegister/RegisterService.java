package kr.co.FortunaFinance_Server.Service.LoginRegister;

import kr.co.FortunaFinance_Server.DTO.LoginRegister.LoginReq;
import kr.co.FortunaFinance_Server.DTO.LoginRegister.RegisterReq;

public interface RegisterService {

    /**
     * Checks whether the provided ID exists in the system.
     *
     * @param ID the ID to be checked
     * @return a string indicating the result of the ID check; if the ID does not exist, returns an empty string
     */
    String ID_Check(String ID);

    /**
     * Registers a new user based on the provided registration request details.
     *
     * @param register_req the registration request containing user details such as ID, password, name,
     *                     birth date, gender, phone number, email, postcode, address, and optional detailed address
     * @return an integer status code indicating the result of the registration operation
     */
    int register(RegisterReq register_req);

    /**
     * Authenticates a user based on the provided login request data.
     *
     * @param loginReq the login request containing user credentials such as ID and password
     * @return an integer status code indicating the result of the login operation
     */
    String login(LoginReq loginReq);
}
