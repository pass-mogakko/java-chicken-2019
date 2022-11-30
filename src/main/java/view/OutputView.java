package view;

import domain.dto.OrderDto;
import domain.menu.Menu;
import domain.table.Table;

import java.util.List;

public class OutputView {
    private static final String TABLE_INFO_MESSAGE = "## 테이블 목록";
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String MENU_INFO_MESSAGE = "## 메뉴 목록";
    private static final String ORDER_COMPLETE_MESSAGE = "주문이 완료되었습니다. 메인 페이지로 돌아갑니다.";
    private static final String ORDER_INFO_MESSAGE = "## 주문 내역\n메뉴 수량 금액";
    private static final String FINAL_PRICE_MESSAGE = "## 최종 결제할 금액";
    private static final String WON = "원";
    private static final String PAYMENT_COMPLETE_MESSAGE = "## 결제가 완료되었습니다. 메인 페이지로 돌아갑니다.";

    public static void printTables(final List<Table> tables) {
        System.out.println();
        System.out.println(TABLE_INFO_MESSAGE);
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        System.out.println();
        System.out.println(MENU_INFO_MESSAGE);
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printOrderCompleteMessage() {
        System.out.println();
        System.out.println(ORDER_COMPLETE_MESSAGE);
        System.out.println();
    }

    public static void printOrders(List<OrderDto> orderDtos) {
        System.out.println();
        System.out.println(ORDER_INFO_MESSAGE);
        for (OrderDto orderDto : orderDtos)
            System.out.println(orderDto.toString());
    }

    public static void printFinalPrice(int finalPrice) {
        System.out.println();
        System.out.println(FINAL_PRICE_MESSAGE);
        System.out.println(finalPrice + WON);
    }

    public static void printPaymentCompleteMessage() {
        System.out.println();
        System.out.println(PAYMENT_COMPLETE_MESSAGE);
        System.out.println();
    }}
