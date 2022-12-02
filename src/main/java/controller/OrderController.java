package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class OrderController {
    static final List<Table> tables = TableRepository.tables();
    static final List<Menu> menus = MenuRepository.menus();

    public void run() {
        OutputView.printTables(tables);
        final Table table = readTable();
        OutputView.printMenus(menus);
        final Menu menu = readMenu();
        final int quantity = readQuantity();
        final Order order = new Order(menu, quantity);
        table.addOrder(order);
    }

    private static Table readTable() {
        try {
            final int tableNumber = InputView.inputTableNumber();
            return TableRepository.findTableByNumber(tableNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readTable();
        }
    }

    public static Menu readMenu() {
        try {
            final int menuNumber = InputView.inputMenu();
            return MenuRepository.findMenuByMenuNumber(menuNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMenu();
        }
    }

    private static int readQuantity() {
        try {
            final int quantity = InputView.inputQuantity();
            return Quantity.validateQuantity(quantity);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readQuantity();
        }
    }
}
