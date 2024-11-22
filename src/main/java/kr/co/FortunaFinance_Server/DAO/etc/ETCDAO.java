package kr.co.FortunaFinance_Server.DAO.etc;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ETCDAO {

    Map<String, Object> uuidCheck(String uuid);

    int uuidDateUpdate(String uuid);

    String getName(int idx);
}
