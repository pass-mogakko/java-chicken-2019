package domain;

import constant.ErrorMessage;
import java.util.Arrays;

public enum MenuNumber {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    TWENTY_ONE(21),
    TWENTY_TWO(22);

    private int number;

    MenuNumber(int number) {
        this.number = number;
    }

    public static void validate(int number) {
        Arrays.stream(MenuNumber.values())
                .filter(MenuNumber-> MenuNumber.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_MENU));
    }
}
