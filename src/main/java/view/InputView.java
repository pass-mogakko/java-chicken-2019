package view;

import view.resource.Main;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputServiceNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        int input = readInt();
        if (!Main.hasMatchingNumber(input)) {
            throw new IllegalArgumentException("잘못된 번호를 입력했습니다.");
        }
        return input;
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    private static int readInt() {
        String readValue = scanner.nextLine();
        IOValidator.validateStringToInteger(readValue);
        return Integer.parseInt(readValue);
    }
}
