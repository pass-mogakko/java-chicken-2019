import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

import static view.InputView.inputCommand;


public class Application {
    static final List<Table> tables = TableRepository.tables();
    static final List<Menu> menus = MenuRepository.menus();

    public static void main(String[] args) {
        final int tableNumber = InputView.inputTableNumber();


        OutputView.printMenus(menus);
    }

    private void printInitSetting() {
        readCommand();
        OutputView.printTables(tables);
    }

    private int readCommand() {
        OutputView.printMainView();
        try {
            return inputCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCommand();
        }
    }
}
