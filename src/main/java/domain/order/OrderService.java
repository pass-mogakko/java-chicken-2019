package domain.order;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.Table;
import domain.table.TableRepository;

import java.util.List;
import java.util.Optional;

public class OrderService {

    public static void createOrder(int tableNumber, int menuNumber, int count) {
        Optional<Table> table = TableRepository.findByNumber(tableNumber);
        Menu menu = MenuRepository.findByNumber(menuNumber);
        OrderRepository.save(table, menu, count);
    }

    public static List<Order> showOrders(int tableNumber) {
        List<Order> orders = OrderRepository.findAllByTableNumber(tableNumber);
        return orders;
    }
}