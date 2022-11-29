package domain;

public enum ErrorCode {

    // 명령어 입력 관련 오류
    INVALID_TYPE_COMMAND("[ERROR] 명령어는 숫자로만 입력하여 주십시오."),
    INVALID_RANGE_COMMAND("[ERROR] 명령어는 안내된 숫자 범위 내에서 선택하여 주십시오.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
