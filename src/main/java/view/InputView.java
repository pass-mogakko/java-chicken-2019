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
