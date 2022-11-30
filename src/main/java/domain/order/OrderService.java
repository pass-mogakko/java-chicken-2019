package domain.order;

import domain.dto.OrderDto;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.Table;
import domain.table.TableRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    public static void createOrder(int tableNumber, int menuNumber, int count) {
        Table table = TableRepository.findByNumber(tableNumber);
        Menu menu = MenuRepository.findByNumber(menuNumber);
        OrderRepository.save(table, menu, count);
    }

    public static List<OrderDto> showOrders(int tableNumber) {
        List<OrderDto> result = new ArrayList<>();
        Table table = TableRepository.findByNumber(tableNumber);
        List<Order> orders = OrderRepository.findAllByTableNumber(tableNumber);
        for (Order order : orders) {
            if (order.getTable() == table)
               result.add(order.makeDto());
        }
        return result;
    }
}