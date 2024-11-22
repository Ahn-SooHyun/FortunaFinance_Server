package kr.co.FortunaFinance_Server.DAO.user;

import kr.co.FortunaFinance_Server.DTO.LoginRegister.LoginDTO;
import kr.co.FortunaFinance_Server.DTO.LoginRegister.LoginReq;
import kr.co.FortunaFinance_Server.DTO.LoginRegister.RegisterDTO;
import kr.co.FortunaFinance_Server.DTO.LoginRegister.RegisterReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginRegisterDAO {

    /**
     * Checks if the given ID exists in the database.
     *
     * @param param the ID to be checked
     * @return the ID if it exists in the database;*/
    String ID_Check (String param);

    /**
     * Registers a new user in the database.
     *
     * @param registerReq the request object containing user registration details
     * @return an integer representing the outcome of the registration; 1 if successful, otherwise 0
     */
    int Register_user_n(RegisterReq registerReq);

    /**
     * Retrieves an index for the registered user from the database.
     *
     * @param registerReq the request object containing user registration details
     * @return an integer*/
    int RegisterIDX(RegisterReq registerReq);

    /**
     * Registers additional profile information for a user.
     *
     * @param registerDTO the data transfer object containing user profile information
     * @return an integer representing the outcome of the registration; 1 if successful, otherwise 0
     */
    int Register_user_p(RegisterDTO registerDTO);

    /**
     * Registers detailed information for a user in the database.
     *
     * @param registerDTO the data transfer object containing user registration details
     * @return an integer representing the outcome of the registration; 1 if successful, otherwise 0
     */
    int Register_user_a(RegisterDTO registerDTO);

    /**
     * Registers a new user with a unique UUID in the database.
     *
     * @param registerDTO the data transfer object containing user profile and registration details
     * @return an integer representing the outcome of the registration; 1 if successful, otherwise 0
     */
    int Register_user_UUID(RegisterDTO registerDTO);

    /**
     * Authenticates a user based on the provided login credentials.
     *
     * @param loginReq the request object containing the user's login details: ID and password
     * @return a LoginDTO containing the user's authenticated information if the login is successful, otherwise null
     */
    LoginDTO Login(LoginReq loginReq);

    /**
     * Increments the number of login failure attempts for a given user.
     *
     * @param loginDTO the data transfer object containing the user's login information and failure count
     */
    void Login_fal (LoginDTO loginDTO);

    /**
     * Sets a unique UUID for the provided login data*/
    int set_UUID (LoginDTO loginDTO);

    /**
     * Resets the number of previous login failure attempts (NoPF) for a given user's login data.
     *
     * @param loginDTO the data transfer object containing the user's login information and failure count
     * @return an integer representing the outcome of the reset operation; 1 if successful, otherwise 0
     */
    void set_NOPF (LoginDTO loginDTO);

}
