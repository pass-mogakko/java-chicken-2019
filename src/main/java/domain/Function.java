package domain;

public enum Function {
    ORDER_REGISTRATION(1, "주문등록"),
    PAYMENT(2, "결제하기"),
    EXIT(3, "프로그램 종료");

    private final int number;
    private final String command;

    Function(final int number, final String command) {
        this.number = number;
        this.command = command;
    }

    @Override
    public String toString() {
        return number + " " + command;
    }
}
