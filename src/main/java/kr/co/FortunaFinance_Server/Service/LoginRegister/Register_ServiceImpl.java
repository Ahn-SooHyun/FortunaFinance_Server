package kr.co.FortunaFinance_Server.Service.LoginRegister;

import kr.co.FortunaFinance_Server.DAO.user.LoginRegister_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Register_ServiceImpl implements Register_Service {

    @Autowired
    private LoginRegister_DAO login_register;

    @Override
    public String ID_Check(String ID) {
        String getID = login_register.ID_Check(ID);
        if (getID == null || getID.equals("")) {
            getID = "";
        }
        System.out.println(getID);

        return getID;
    }

}
