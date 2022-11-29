package domain;

public enum ErrorCode {

    // 입력값 타입 오류
    INVALID_TYPE("[ERROR] 숫자로만 입력하여 주십시오."),

    // 입력값 유효성 오류 (범위 오류)
    INVALID_COMMAND_RANGE("[ERROR] 명령어는 안내된 숫자 범위 내에서 선택하여 주십시오."),
    INVALID_TABLE_NUMBER_RANGE("[ERROR] 테이블 번호는 1 ~ 8번 중에서 선택하여 주십시오."),
    INVALID_MENU_NUMBER_RANGE("[ERROR] 메뉴에 있는 번호만 입력하여 주십시오.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
