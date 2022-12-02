package view;

import static view.resource.Message.FORMAT_PAY_IN_PROGRESS;
import static view.resource.Message.INPUT_MENU;
import static view.resource.Message.INPUT_MENU_QUANTITY;
import static view.resource.Message.INPUT_PAY_TYPE;
import static view.resource.Message.INPUT_SERVICE;
import static view.resource.Message.INPUT_TABLE;

import view.resource.PayTypeCommand;
import view.resource.MainCommand;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static MainCommand inputServiceNumber() {
        System.out.println(INPUT_SERVICE.getValue());
        int serviceNumber = readInt();
        System.out.print(System.lineSeparator());
        return MainCommand.findByNumber(serviceNumber);
    }

    public static int inputTableNumber() {
        System.out.println(INPUT_TABLE.getValue());
        int tableNumber = readInt();
        System.out.print(System.lineSeparator());
        return tableNumber;
    }

    public static int inputMenuNumber() {
        System.out.println(INPUT_MENU.getValue());
        int menuNumber = readInt();
        System.out.print(System.lineSeparator());
        return menuNumber;
    }

    public static int inputMenuQuantity() {
        System.out.println(INPUT_MENU_QUANTITY.getValue());
        int menuAmount = readNaturalNumber();
        System.out.print(System.lineSeparator());
        return menuAmount;
    }

    public static PayTypeCommand inputPayTypeCommand(int tableNumber) {
        System.out.printf(FORMAT_PAY_IN_PROGRESS.getValue(), tableNumber);
        System.out.println(INPUT_PAY_TYPE.getValue());
        int payTypeNumber = readInt();
        System.out.print(System.lineSeparator());
        return PayTypeCommand.findByNumber(payTypeNumber);
    }

    private static int readNaturalNumber() {
        String readValue = scanner.nextLine();
        IOValidator.validateStringToNaturalNumber(readValue);
        return Integer.parseInt(readValue);
    }


    private static int readInt() {
        String readValue = scanner.nextLine();
        IOValidator.validateStringToInteger(readValue);
        return Integer.parseInt(readValue);
    }
}
