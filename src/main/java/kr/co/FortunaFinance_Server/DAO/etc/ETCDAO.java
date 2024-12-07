package kr.co.FortunaFinance_Server.DAO.etc;

import kr.co.FortunaFinance_Server.DTO.etc.UserNameListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ETCDAO {

    Map<String, Object> uuidCheck(String uuid);

    int uuidDateUpdate(String uuid);

    String getName(int idx);

    List<UserNameListDTO> User_Name_List();
}
