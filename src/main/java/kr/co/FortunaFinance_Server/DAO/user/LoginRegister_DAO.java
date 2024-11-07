package kr.co.FortunaFinance_Server.DAO.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginRegister_DAO {

    String ID_Check (String param);
}
