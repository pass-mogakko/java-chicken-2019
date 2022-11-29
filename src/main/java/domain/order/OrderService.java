package domain.order;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.Table;
import domain.table.TableRepository;

public class OrderService {

    public static void createOrder(int tableNumber, int menuNumber, int count) {
        Table table = TableRepository.findByNumber(tableNumber);
        Menu menu = MenuRepository.findByNumber(menuNumber);
        OrderRepository.save(table, menu, count);
    }
}
