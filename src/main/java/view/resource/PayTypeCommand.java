package view.resource;

import java.util.Arrays;

public enum PayTypeCommand {

    CARD(1),
    CASH(2)
    ;

    private final int number;

    PayTypeCommand(int number) {
        this.number = number;
    }

    private int getNumber() {
        return number;
    }

    public static PayTypeCommand findByNumber(int number) {
        return Arrays.stream(values())
                .filter(command -> command.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> {throw new IllegalArgumentException("지정된 결제 유형 입력값이 아닙니다.");});
    }
}
