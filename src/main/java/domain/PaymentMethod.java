package domain;

import java.util.Arrays;

public enum PaymentMethod {
    CARD(1),
    CASH(2);

    private final int number;

    PaymentMethod(int number) {
        this.number = number;
    }

    public static boolean isCash(PaymentMethod method) {
        return method == CASH;
    }

    public static PaymentMethod validateMethod(final int number) {
        return Arrays.stream(PaymentMethod.values())
                .filter(paymentMethod -> paymentMethod.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 1(카드) 혹은 2(현금)만 입력할 수 있습니다."));
    }
}
