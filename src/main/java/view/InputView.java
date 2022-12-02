package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCommand() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.print(System.lineSeparator());
        System.out.println("## 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenu() {
        System.out.print(System.lineSeparator());
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputQuantity() {
        System.out.print(System.lineSeparator());
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }

    public static int inputPaymentMethod(final int tableNumber) {
        System.out.print(System.lineSeparator());
        System.out.printf("## %d번 테이블의 결제를 진행합니다.", tableNumber);
        System.out.print(System.lineSeparator());
        System.out.println("## 신용 카드는 1번, 현금은 2번");
        return scanner.nextInt();
    }
}
