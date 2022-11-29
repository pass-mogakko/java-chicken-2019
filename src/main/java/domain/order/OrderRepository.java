package domain.order;

import domain.menu.Menu;
import domain.table.Table;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    static void save(Table table, Menu menu, int count) {
        orders.add(new Order(table, menu, count));
    }

//    public static List<Order> findByTableNumber() {}
}
