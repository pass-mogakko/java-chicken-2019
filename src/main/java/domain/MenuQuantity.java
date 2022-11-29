package domain;

import constant.Constant;
import constant.ErrorMessage;

public class MenuQuantity {

    public MenuQuantity(int quantity) {
        validate(quantity);
    }

    private void validate(int quantity) {
        if (quantity < Constant.MENU_QUANTITY_MIN || quantity > Constant.MENU_QUANTITY_MAX) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_MENU_QUANTITY_RANGE);
        }
    }
}
