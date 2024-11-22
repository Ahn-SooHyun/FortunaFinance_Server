package kr.co.FortunaFinance_Server.Service.etc;

public interface ETCService {

    int uuidCheck(String uuid);

    String getName(int idx);

    void uuidDateUpdate(String uuid);
}
