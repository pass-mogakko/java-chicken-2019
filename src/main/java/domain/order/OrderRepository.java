package domain.order;

import domain.menu.Menu;
import domain.table.Table;
import domain.table.TableRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    static void save(Table table, Menu menu, int count) {
        orders.add(new Order(table, menu, count));
    }

    public static List<Order> findAllByTableNumber(int tableNumber) {
        List<Order> result = new ArrayList<>();
        Table table = TableRepository.findByNumber(tableNumber);
        for (Order order : orders) {
            if (order.isEqualTable(table)) {
                result.add(order);
            }
        }
        return result;
    }
}
