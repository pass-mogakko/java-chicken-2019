package view.resource;

import java.util.Arrays;

public enum MainCommand {

    ORDER(1, "주문등록"),
    PAY(2, "결제하기"),
    EXIT(3, "프로그램 종료")
    ;

    private final int number;
    private final String name;

    MainCommand(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public static MainCommand findByNumber(int number) {
        return Arrays.stream(values())
                .filter(value -> number == value.number)
                .findFirst()
                .orElseThrow(() -> {throw new IllegalArgumentException("지정된 기능 입력값이 아닙니다.");});
    }
}
