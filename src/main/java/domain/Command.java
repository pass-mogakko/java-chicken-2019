package domain;

import static java.util.Arrays.stream;

public enum Command {
    ORDER_REGISTRATION(1),
    PAYMENT(2),
    EXIT(3);

    private final int command;

    Command(final int command) {
        this.command = command;
    }

    public static int readInputCommand(final int command) {
        validateCommand(command);
        return command;
    }

    private static void validateCommand(final int command) {
        if (stream(Command.values())
                .noneMatch(number -> number.getCommand() == command)
        ) {
            throw new IllegalArgumentException("[ERROR] 1,2,3만 입력할 수 있습니다.");
        }
    }

    public int getCommand() {
        return this.command;
    }

    public static boolean isExitCommand(final int inputCommand) {
        return inputCommand == EXIT.getCommand();
    }
}
