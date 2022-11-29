package domain;

import constant.ErrorMessage;
import java.util.Arrays;

public enum PaymentMethod {
    ONE(1),
    TWO(2);

    private final int selection;

    PaymentMethod(int selection) {
        this.selection = selection;
    }

    public static void validate(int selection) {
        Arrays.stream(PaymentMethod.values())
                .filter(paymentMethod -> paymentMethod.selection == selection)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_FUNCTION));
    }
}
