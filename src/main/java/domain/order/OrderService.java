package domain.order;

import domain.dto.OrderDto;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.Table;
import domain.table.TableRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderService {

    public static void createOrder(int tableNumber, int menuNumber, int count) {
        Optional<Table> table = TableRepository.findByNumber(tableNumber);
        Menu menu = MenuRepository.findByNumber(menuNumber);
        OrderRepository.save(table, menu, count);
    }

    public static List<OrderDto> showOrders(int tableNumber) {
        List<OrderDto> result = new ArrayList<>();

        List<Order> orders = OrderRepository.findAllByTableNumber(tableNumber);
        for (Order order : orders) {
            result.add(order.makeDto());
        }
        return result;
    }
}