package kr.co.FortunaFinance_Server.Util;

import lombok.Data;

@Data
public class ResponsData {

    private String code; //성공:200, 실패: 500.
    private String message; //에러내역 ( properties에서 관리 )

    private Object data; // response 값을 담는다.

    //default 설정 성공
    public ResponsData() {
        this.code = "200"; //성공 코드
        this.message = "success";
    }
}
