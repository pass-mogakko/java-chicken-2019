package controller;

import domain.Menu;
import domain.MenuNumber;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import domain.TablesNumber;
import java.util.List;
import view.InputView;
import view.OutputView;

public class OrderController {

    private static final OrderController orderController = new OrderController();

    private OrderController() {

    }

    public static OrderController getInstance() {
        return orderController;
    }

    public static void run() {
        int orderTableNumber = requestOrderTableNumber();
        int registerMenuNumber = requestRegisterMenu();
        int menuQuantity = requestMenuQuantity();

    }

    private static int requestOrderTableNumber() {
        List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        int orderTableNumber = InputView.requestOrderTableNumber();
        try {
            TablesNumber.validate(orderTableNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            requestOrderTableNumber();
        }
        return orderTableNumber;
    }

    private static int requestRegisterMenu() {
        List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        int registerMenu = InputView.requestRegisterMenu();
        try {
            MenuNumber.validate(registerMenu);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            requestRegisterMenu();
        }
        return registerMenu;
    }

    private static int requestMenuQuantity() {
        int menuQuantity = InputView.requestMenuQuantity();
        return 0;
    }
}
