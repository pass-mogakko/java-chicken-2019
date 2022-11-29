package view;

import constant.Message;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int requestOrderTableNumber() {
        System.out.println();
        System.out.printf(Message.INFO_MESSAGE_FORM, Message.SELECT_TABLE);
        System.out.println();
        return scanner.nextInt();
    }

    public static int requestMainScreenSelection() {
        System.out.println();
        System.out.printf(Message.INFO_MESSAGE_FORM, Message.REQUEST_FUNCTION);
        System.out.println();
        return scanner.nextInt();
    }

    public static int requestRegisterMenu() {
        System.out.println();
        System.out.printf(Message.INFO_MESSAGE_FORM, Message.REQUEST_REGISTER_MENU);
        System.out.println();
        return scanner.nextInt();
    }

    public static int requestMenuQuantity() {
        System.out.println();
        System.out.printf(Message.INFO_MESSAGE_FORM, Message.REQUEST_MENU_QUANTITY);
        System.out.println();
        return scanner.nextInt();
    }
}
