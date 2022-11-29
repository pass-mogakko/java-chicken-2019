package domain.order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    private static void save(int tableNumber, int , int count) {
        orders.add(new Order(table, menu, count));
    }

//    public static List<Order> findByTableNumber() {}
}
