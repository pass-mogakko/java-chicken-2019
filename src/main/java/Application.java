import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

import static domain.Command.readInputCommand;


public class Application {
    static final List<Table> tables = TableRepository.tables();
    static final List<Menu> menus = MenuRepository.menus();

    public static void main(String[] args) {
        int command = readCommand();

        while (!Command.isExit(command)) {
            runPOS(command);
            command = readCommand();
        }
        OutputView.printMenus(menus);
    }

    private static void runPOS(final int command) {
        OutputView.printTables(tables);
        if (Command.isOrderRegistration(command)) {
            //
        }
        if (Command.isPayment(command)) {
            //
        }
    }

    private static void registerOrder(){
        final int tableNumber = readTableNumber();
        final int menuNumber = readMenuNumber();
        final int quantity = readQuantity();
        Order order = new Order(tableNumber,menuNumber,quantity);
    }

    private static int readCommand() {
        OutputView.printMainView();
        try {
            int command = InputView.inputCommand();
            return readInputCommand(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCommand();
        }
    }

    private static int readTableNumber() {
        try {
            final int tableNumber = InputView.inputTableNumber();
            validateTableNumber(tableNumber);
            return tableNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readTableNumber();
        }
    }

    public static void validateTableNumber(final int number) {
        if (tables.stream()
                .noneMatch(table -> table.getTableNumber() == number)) {
            throw new IllegalArgumentException("[ERROR] 허용된 테이블이 아닙니다.");
        }
    }

    public static int readMenuNumber(){
        // TODO validate
        return InputView.inputMenu();
    }

    private static int readQuantity() {
        return InputView.inputQuantity();
    }
}