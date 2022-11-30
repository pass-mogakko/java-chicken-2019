package view.resource;

import java.util.Arrays;

public enum Main {

    ORDER(1, "주문등록"),
    PAY(2, "결제하기"),
    EXIT(3, "프로그램 종료")
    ;

    private final int number;
    private final String name;

    Main(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    // TODO 결제유형 선택 시에도 같은 방식 이용
    public static boolean hasMatchingNumber(int command) {
        return Arrays.stream(values())
                .anyMatch(value -> command == value.number);
    }
}
