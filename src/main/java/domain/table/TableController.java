package domain.table;

import domain.Validator;
import view.InputView;

public class TableController {
    private static final Validator validator = new Validator();

    public static int readNumber() {
        int tableNumber = getInputTableNumberToOrder();
        return tableNumber;
    }

    public static void updateTable(int tableNumber) {
        TableService.updateTable(tableNumber);

    }

    private static int getInputTableNumberToOrder() {
        while (true) {
            try {
                String input = InputView.inputTableNumberToOrder();
                return validator.validateTableNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
