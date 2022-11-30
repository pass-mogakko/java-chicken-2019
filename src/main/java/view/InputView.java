package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_COMMAND_MESSAGE = "수행할 작업을 선택하세요. (1. 주문등록 / 2. 결제하기 / 3. 프로그램 종료)";
    private static final String REQUEST_ORDERING_TABLE_NUMBER_MESSAGE = "## 주문할 테이블을 선택하세요.";
    private static final String REQUEST_MENU_TYPE_MESSAGE = "## 주문할 메뉴를 선택하세요.";
    private static final String REQUEST_MENU_COUNT_MESSAGE = "## 주문할 수량을 입력하세요.";
    private static final String REQUEST_PAYING_TABLE_NUMBER_MESSAGE = "## 결제할 테이블을 선택하세요.";
    private static final String PAYING_TABLE_INFO_MESSAGE_FRONT = "## ";
    private static final String PAYING_TABLE_INFO_MESSAGE_BACK = "번 테이블의 결제를 진행합니다.";
    private static final String REQUEST_PAYMENT_NUMBER_MESSAGE = "## 결제할 방법을 선택하세요. 1. 신용 카드 / 2. 현금";

    public static String inputCommand() {
        System.out.println(REQUEST_COMMAND_MESSAGE);
        return Console.readLine();
    }

    public static String inputTableNumberToOrder() {
        System.out.println();
        System.out.println(REQUEST_ORDERING_TABLE_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String inputMenuNumber() {
        System.out.println();
        System.out.println(REQUEST_MENU_TYPE_MESSAGE);
        return Console.readLine();
    }

    public static String inputMenuCount() {
        System.out.println();
        System.out.println(REQUEST_MENU_COUNT_MESSAGE);
        return Console.readLine();
    }

    public static String inputTableNumberToPay() {
        System.out.println();
        System.out.println(REQUEST_PAYING_TABLE_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String inputPaymentNumber(int tableNumber) {
        System.out.println();
        System.out.println(PAYING_TABLE_INFO_MESSAGE_FRONT + tableNumber + PAYING_TABLE_INFO_MESSAGE_BACK);
        System.out.println(REQUEST_PAYMENT_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
