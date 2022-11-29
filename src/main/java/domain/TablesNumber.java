package domain;

import constant.ErrorMessage;
import java.util.Arrays;

public enum TablesNumber {
    ONE(1),
    TWO(2),
    THREE(3),
    FIVE(5),
    SIX(6),
    EIGHT(8);

    private final int number;

    TablesNumber(int number) {
        this.number = number;
    }

    public static void validate(int number) {
        Arrays.stream(TablesNumber.values())
                .filter(tablesNumber -> tablesNumber.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_TABLE));
    }
}
