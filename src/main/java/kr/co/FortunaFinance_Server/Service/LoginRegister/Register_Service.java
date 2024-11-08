package kr.co.FortunaFinance_Server.Service.LoginRegister;

import kr.co.FortunaFinance_Server.DTO.user.LoginRegister.Register_Req;

public interface Register_Service {

    /**
     * ID Check
     * @param ID
     * @return
     */
    String ID_Check(String ID);

    /**
     * register
     * @param register_req
     * @return
     */
    String Register(Register_Req register_req);
}
