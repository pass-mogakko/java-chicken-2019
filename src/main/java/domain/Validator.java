package domain;

import static domain.ErrorCode.*;

public class Validator {
    private final TypeConverter converter = new TypeConverter();

    public int validateCommand(String input) {
        int command = converter.convertStringToInt(input);
        checkCommandRange(command);
        return command;
    }

    public int validateTableNumber(String input) {
        int command = converter.convertStringToInt(input);
        checkTableNumberRange(command);
        return command;
    }

    private void checkCommandRange(int command) {
        if (command < 1 || command > 3) {
            throw new IllegalArgumentException(INVALID_COMMAND_RANGE.getMessage());
        }
    }

    private void checkTableNumberRange(int tableNumber) {
        if (tableNumber < 1 || tableNumber > 8) {
            throw new IllegalArgumentException(INVALID_TABLE_NUMBER_RANGE.getMessage());
        }
    }

}
