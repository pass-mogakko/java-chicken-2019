package controller;

import domain.Table;
import domain.TableRepository;
import java.util.List;
import view.OutputView;

public class MainScreenController {

    private static final MainScreenController mainController = new MainScreenController();

    private MainScreenController() {

    }

    public static MainScreenController getInstance() {
        return mainController;
    }

    public void run() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        //        final int tableNumber = InputView.inputTableNumber();
        //
        //        final List<Menu> menus = MenuRepository.menus();
        //        OutputView.printMenus(menus);
    }
}
