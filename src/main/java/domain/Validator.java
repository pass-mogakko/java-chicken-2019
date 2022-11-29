package domain;

import static domain.ErrorCode.*;

public class Validator {

    public void validateCommandRange(int command) {
        if (command < 1 || command > 3) {
            throw new IllegalArgumentException(INVALID_RANGE_COMMAND.getMessage());
        }
    }

}
