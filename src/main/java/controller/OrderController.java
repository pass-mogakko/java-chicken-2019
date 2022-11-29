package controller;

import domain.Menu;
import domain.MenuNumber;
import domain.MenuQuantity;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import domain.TablesNumber;
import java.util.List;
import view.InputView;
import view.OutputView;

public class OrderController {

    public static void run() {
        int orderTableNumber = requestOrderTableNumber();
        int registerMenuNumber = requestRegisterMenu();
        int menuQuantity = requestMenuQuantity();

        orderMenu(orderTableNumber, registerMenuNumber, menuQuantity);
        MainScreenController.run();
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
        int quantity = InputView.requestMenuQuantity();
        try {
            new MenuQuantity(quantity);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            requestMenuQuantity();
        }
        return quantity;
    }

    private static void orderMenu(int orderTableNumber, int registerMenuNumber, int menuQuantity) {
        Menu menu = MenuRepository.findMenuByNumber(registerMenuNumber);
        int price = menu.computePrice(menuQuantity);

        TableRepository.menuOrder(orderTableNumber, price);
    }
}
