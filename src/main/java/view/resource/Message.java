package view.resource;

public enum Message {

    HEADER_MAIN("## 메인화면"),
    HEADER_TABLES("## 테이블 목록"),
    HEADER_TOTAL_PAYMENT("## 최종 결제할 금액"),

    INPUT_SERVICE("## 원하는 기능을 선택하세요."),
    INPUT_TABLE("## 테이블을 선택하세요."),
    INPUT_MENU("## 등록할 메뉴를 선택하세요."),
    INPUT_MENU_QUANTITY("## 메뉴의 수량을 입력하세요."),
    INPUT_PAY_TYPE("## 신용 카드는 1번, 현금은 2번"),

    FORMAT_PAY_IN_PROGRESS("## %d번 테이블의 결제를 진행합니다." + System.lineSeparator()),

    EXIT("치킨집 포스기를 종료합니다.")
    ;

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
