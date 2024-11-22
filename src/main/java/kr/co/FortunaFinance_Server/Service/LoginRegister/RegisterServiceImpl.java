package kr.co.FortunaFinance_Server.Service.LoginRegister;

import kr.co.FortunaFinance_Server.DAO.user.LoginRegisterDAO;
import kr.co.FortunaFinance_Server.DTO.LoginRegister.LoginDTO;
import kr.co.FortunaFinance_Server.DTO.LoginRegister.LoginReq;
import kr.co.FortunaFinance_Server.DTO.LoginRegister.RegisterDTO;
import kr.co.FortunaFinance_Server.DTO.LoginRegister.RegisterReq;
import kr.co.FortunaFinance_Server.Util.BCryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private LoginRegisterDAO login_register;

    @Override
    public String ID_Check(String ID) {
        String getID = login_register.ID_Check(ID);
        if (getID == null || getID.equals("")) {
            getID = "";
        }

        return getID;
    }

    @Transactional
    @Override
    public int register(RegisterReq register_req) {
        int user_n = login_register.Register_user_n(register_req);
        if (user_n != 1) {
            return 0;
        }

        int IDX = login_register.RegisterIDX(register_req);
        if (IDX == 0) {
            return 0;
        }
        RegisterDTO registerDTO = new RegisterDTO(register_req, IDX);

        if (login_register.Register_user_p(registerDTO) != 1) {
            return 0;
        }
        if (login_register.Register_user_a(registerDTO) != 1) {
            return 0;
        }

        if (login_register.Register_user_UUID(registerDTO) != 1) {
            return 0;
        }

        return 1;
    }

    @Override
    public String login(LoginReq loginReq) {
        BCryptService bCrypt = new BCryptService();
        LoginDTO loginDTO = login_register.Login(loginReq);

        //ID 존재 여부
        if (loginDTO == null) {
            return null;
        }

        //0 1 2 3 4 5
        if(loginDTO.getNopf() >= 5) {
            //5번 틀렸네~
            return null;
        }

        //패스워드 여부
        if (!bCrypt.checkPassword(loginReq.getPw(), loginDTO.getPassword())) {
            //password 틀리다.
            login_register.Login_fal(loginDTO);

            return null;
        }

        UUID uuid = UUID.randomUUID();
        loginDTO.setUuid(uuid.toString());

        if (login_register.set_UUID(loginDTO) != 1) {
            return null;
        }

        login_register.set_NOPF(loginDTO);

        return loginDTO.getUuid();
    }

}
