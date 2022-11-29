package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_COMMAND_MESSAGE = "수행할 작업을 선택하세요. (1. 주문등록 / 2. 결제하기 / 3. 프로그램 종료)";
    private static final String REQUEST_TABLE_NUMBER_MESSAGE = "## 주문할 테이블을 선택하세요.";

    public static String inputCommand() {
        System.out.println(REQUEST_COMMAND_MESSAGE);
        return Console.readLine();
    }

    public static String inputTableNumber() {
        System.out.println();
        System.out.println(REQUEST_TABLE_NUMBER_MESSAGE);
        return Console.readLine();
    }

//    public static String inputMenuNumber() {
//        System.out.println();
//        return Console.readLine();
//    }
}
