package domain;

import java.util.Arrays;

public enum Command {
    ORDER_REGISTRATION(1),
    PAYMENT(2),
    EXIT(3);

    private final int command;

    Command(final int command) {
        this.command = command;
    }

    public static int readInputCommand(final int command){
        validateCommand(command);
        return command;
    }

    private static void validateCommand(final int command) {
        if (!Arrays.stream(Command.values())
                .findAny()
                .equals(command)
        ) {
            throw new IllegalArgumentException("[ERROR] 1,2,3만 입력할 수 있습니다.");
        }
    }

    public int getCommand(){
        return this.command;
    }
}
