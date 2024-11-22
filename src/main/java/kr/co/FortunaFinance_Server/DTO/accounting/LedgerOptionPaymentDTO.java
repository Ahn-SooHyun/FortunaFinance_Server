package kr.co.FortunaFinance_Server.DTO.accounting;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class LedgerOptionPaymentDTO {
    private String cpindex;
    private String bank;
    @Getter(AccessLevel.NONE) // Lombok에 의한 자동 getter 생성 방지
    private String cpnum;
    private String representative;

    // cpnum에 대한 사용자 정의 getter
    public String getCpnum() {
        int dashIndex = cpnum.indexOf('-');
        String visiblePart = cpnum.substring(0, dashIndex); // 첫 번째 '-' 전까지 보여줌
        String rest = cpnum.substring(dashIndex); // 첫 '-' 이후 나머지 부분
        String maskedPart = maskExceptLastTwoDigits(rest); // 나머지 부분에서 마지막 두 숫자를 제외하고 마스킹
        return visiblePart + maskedPart;
    }

    private String maskExceptLastTwoDigits(String input) {
        return input.replaceAll("(\\d)(?=(?:\\D*\\d){2})", "*");
    }
}