package kr.co.FortunaFinance_Server.Service.etc;

import kr.co.FortunaFinance_Server.DAO.etc.ETCDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@Service
public class ETCServiceImpl implements ETCService {

    @Autowired
    private ETCDAO etcDAO;

    @Override
    public void uuidDateUpdate(String uuid) {
        etcDAO.uuidDateUpdate(uuid);
    }

    @Override
    public int uuidCheck(String uuid) {

        Map<String, Object> result = etcDAO.uuidCheck(uuid);

        if (result == null) {
            return -1; // 쿼리 결과가 없을 경우 -1 반환
        }

        // User_IDX 값이 null이거나 존재하지 않는 경우 -1 반환
        Integer IDX = (Integer) result.get("User_IDX");
        if (IDX == null) {
            return -1;
        }

        // UUID_Date 값 변환
        java.sql.Timestamp timestamp = (java.sql.Timestamp) result.get("UUID_Date");
        if (timestamp == null) {
            return 0; // UUID_Date가 null인 경우 0 반환
        }
        LocalDateTime uuidDate = timestamp.toLocalDateTime(); // Timestamp를 LocalDateTime으로 변환

        // 현재 시간과 UUID_Date 간의 차이를 구해 15분 이상 차이나면 0 반환
        if (Duration.between(uuidDate, LocalDateTime.now()).toMinutes() >= 15) {
            return 0; // 15분 이상 차이나면 0 반환
        }

        return IDX; // 모든 조건을 만족하는 경우 User_IDX 반환
    }

    @Override
    public String getName(int idx) {

        return etcDAO.getName(idx);
    }

}
