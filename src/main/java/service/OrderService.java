package service;

import domain.Menu;
import domain.Table;
import domain.order.OrderedMenus;

public class OrderService {

    private static final OrderService instance = new OrderService();

    private OrderService() { }

    public static OrderService getInstance() {
        return instance;
    }

    public void addTableOrder(int tableNumber, int menuNumber, int quantity) {
        Table tableForOrder = TableService.getTableByNumber(tableNumber);
        Menu menuToOrder = MenuService.getMenuByNumber(menuNumber);
        tableForOrder.updateOrder(menuToOrder, quantity);
    }

    public OrderedMenus getOrderByTable(int tableNumber) {
        Table table = TableService.getTableByNumber(tableNumber);
        return table.getOrderMenus();
    }
}
