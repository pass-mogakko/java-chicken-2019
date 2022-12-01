package view.resource;

public enum Format {
    MAIN_SERVICE("%d - %s" + System.lineSeparator()),

    TABLE_TOP_LINE("┌ ─ ┐"),
    TABLE_FORMAT("| %s |"),
    TABLE_BOTTOM_LINE("└ ─ ┘"),

    ORDER_EMPTY("주문 내역이 존재하지 않습니다."),
    ORDER_INDEX("메뉴 수량 금액"),
    ORDER_FORMAT("%s %d %d")
    ;

    private final String value;

    Format(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
