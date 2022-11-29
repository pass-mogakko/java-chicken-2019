package domain;

import java.util.List;

import static domain.ErrorCode.*;

public class Validator {
    private final TypeConverter converter = new TypeConverter();

    public int validateCommand(String input) {
        int command = converter.convertStringToInt(input);
        checkCommandRange(command);
        return command;
    }

    public int validateTableNumber(String input) {
        int tableNumber = converter.convertStringToInt(input);
        checkTableNumberRange(tableNumber);
        return tableNumber;
    }

    public int validateMenuNumber(String input) {
        int menuNumber = converter.convertStringToInt(input);
        checkMenuNumberRange(menuNumber);
        return menuNumber;
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

    private void checkMenuNumberRange(int menuNumber) {
        if (!List.of(1, 2, 3, 4, 5, 6, 21, 22).contains(menuNumber)) {
            throw new IllegalArgumentException(INVALID_MENU_NUMBER_RANGE.getMessage());
        }
    }

}
