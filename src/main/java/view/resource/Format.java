package view.resource;

import dto.TableDTO;

public enum Format {
    MAIN_SERVICE("%d - %s" + System.lineSeparator()),

    TABLE_TOP_LINE("┌ ─ ┐"),
    TABLE_FORMAT("| %s |"),
    TABLE_BOTTOM_LINE("└ ─ ┘"),
    TABLE_ORDER_DISPLAY("₩"),

    ORDER_EMPTY("주문 내역이 존재하지 않습니다."),
    ORDER_INDEX("메뉴 수량 금액"),
    ORDER_FORMAT("%s %d %d"),

    TOTAL_PAYMENT("%d원" + System.lineSeparator())
    ;

    private final String value;

    Format(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String getRightTableBottomLine(TableDTO tableDTO) {
        String bottomLine = TABLE_BOTTOM_LINE.getValue();
        if (tableDTO.hasOrder()) {
            return bottomLine.replace("─", TABLE_ORDER_DISPLAY.getValue());
        }
        return bottomLine;
    }
}
