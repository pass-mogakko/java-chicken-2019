package view;

import view.resource.PayTypeCommand;
import view.resource.MainCommand;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    // TODO 메시지 상수화
    public static MainCommand inputServiceNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        int serviceNumber = readInt();
        System.out.print(System.lineSeparator());
        return MainCommand.findByNumber(serviceNumber);
    }

    public static int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        int tableNumber = readInt();
        System.out.print(System.lineSeparator());
        return tableNumber;
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        int menuNumber = readInt();
        System.out.print(System.lineSeparator());
        return menuNumber;
    }

    public static int inputMenuAmount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        int menuAmount = readNaturalNumber();
        System.out.print(System.lineSeparator());
        return menuAmount;
    }

    public static PayTypeCommand inputPayTypeCommand(int tableNumber) {
        System.out.printf("## %d번 테이블의 결제를 진행합니다." + System.lineSeparator(), tableNumber);
        System.out.println("## 신용 카드는 1번, 현금은 2번");
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
