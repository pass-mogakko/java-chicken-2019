package view;

import view.resource.Main;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputServiceNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        int serviceNumber = readInt();
        System.out.print(System.lineSeparator());
        if (!Main.hasMatchingNumber(serviceNumber)) {
            throw new IllegalArgumentException("잘못된 번호를 입력했습니다.");
        }
        return serviceNumber;
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        int tableNumber = readInt();
        System.out.print(System.lineSeparator());
        return tableNumber;
    }

    private static int readInt() {
        String readValue = scanner.nextLine();
        IOValidator.validateStringToInteger(readValue);
        return Integer.parseInt(readValue);
    }
}
