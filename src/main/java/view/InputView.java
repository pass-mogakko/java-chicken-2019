package view;

import constant.Message;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println();
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int requestMainScreenSelection() {
        System.out.println();
        System.out.printf(Message.INFO_MESSAGE_FORM, Message.REQUEST_FUNCTION);
        System.out.println();
        return scanner.nextInt();
    }
}
