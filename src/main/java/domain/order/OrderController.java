package domain.order;

import domain.Validator;
import domain.menu.Menu;
import domain.menu.MenuController;
import domain.table.Table;
import domain.table.TableController;
import view.OutputView;

import java.util.List;

public class OrderController {

    public static void makeOrder(List<Table> tables, List<Menu> menus) {
        OutputView.printTables(tables);
        int tableNumber = TableController.readNumber();
        TableController.updateTable(tableNumber);
        OutputView.printMenus(menus);
        int menuNumber = MenuController.readNumber();
        int menuCount = MenuController.readCount();
        OrderService.createOrder(tableNumber, menuNumber, menuCount);
        OutputView.printOrderCompleteMessage();
    }

}
