import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

import static domain.Command.isExitCommand;
import static domain.Command.readInputCommand;


public class Application {
    static final List<Table> tables = TableRepository.tables();
    static final List<Menu> menus = MenuRepository.menus();
    static final List<Payment> payments = PaymentRepository.payments();

    public static void main(String[] args) {
        int command = readCommand();

        while (!isExitCommand(command)) {
            runPOS();
            command = readCommand();
        }
        OutputView.printMenus(menus);
    }

    private static void runPOS() {
        printInitSetting();
        //TODO 1, 2번의 경우
    }

    private static void printInitSetting() {
        OutputView.printTables(tables);
        readTableNumber();
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
}