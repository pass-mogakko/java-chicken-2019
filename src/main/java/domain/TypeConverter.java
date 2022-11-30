package domain;

import static domain.ErrorCode.*;

public class TypeConverter {

    public int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TYPE.getMessage());
        }
    }

}
