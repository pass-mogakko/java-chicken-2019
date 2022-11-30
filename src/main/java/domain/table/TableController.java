package domain.table;

import domain.Validator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class TableController {
    private static final Validator validator = new Validator();

    public static int readNumberToOrder(List<Table> tables) {
        OutputView.printTables(tables);
        int tableNumber = getInputTableNumberToOrder();
        return tableNumber;
    }

    public static void updateTable(int tableNumber) {
        TableService.updateTable(tableNumber);
    }

    public static int readNumberToPay(List<Table> tables) {
        OutputView.printTables(tables);
        int tableNumber = readTableNumberToPay();
        return tableNumber;
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

    private static int readTableNumberToPay() {
        while (true) {
            try {
                String input = InputView.inputTableNumberToPay();
                return validator.validateTableNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
