package domain;

import static domain.ErrorCode.*;

public class Validator {
    private final TypeConverter converter = new TypeConverter();

    public int validateInputCommand(String input) {
        int command = converter.convertStringToInt(input);
        validateCommandRange(command);
        return command;
    }

    private void validateCommandRange(int command) {
        if (command < 1 || command > 3) {
            throw new IllegalArgumentException(INVALID_RANGE_COMMAND.getMessage());
        }
    }

}
