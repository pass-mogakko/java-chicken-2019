package domain;

public enum Command {
    ORDER_REGISTRATION(1),
    PAYMENT(2),
    EXIT(3);

    private final int command;

    Command(final int command) {
        this.command = command;
    }
}
