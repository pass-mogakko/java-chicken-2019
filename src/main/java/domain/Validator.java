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

    public int validateMenuCount(String input) {
        int menuCount = converter.convertStringToInt(input);
        checkMenuCountRange(menuCount);
        return menuCount;
    }

    public int validatePaymentNumber(String input) {
        int payment = converter.convertStringToInt(input);
        checkPaymentNumberRange(payment);
        return payment;
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

    private void checkMenuCountRange(int menuCount) {
        if (menuCount > 99) {
            throw new IllegalArgumentException(INVALID_MENU_COUNT_RANGE_TOP.getMessage());
        }
        if (menuCount < 1) {
            throw new IllegalArgumentException(INVALID_MENU_COUNT_RANGE_BOTTOM.getMessage());
        }
    }

    private void checkPaymentNumberRange(int payment) {
        if (payment < 1 || payment > 2) {
            throw new IllegalArgumentException(INVALID_PAYMENT_NUMBER_RANGE.getMessage());
        }
    }

}