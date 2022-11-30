package domain.order;

import domain.dto.OrderDto;
import view.OutputView;

import java.util.List;

public class OrderController {

    public static void createOrder(int tableNumber, int menuNumber, int menuCount) {
        OrderService.createOrder(tableNumber, menuNumber, menuCount);
        OutputView.printOrderCompleteMessage();
    }

    public static void showOrders(int tableNumber){
        List<OrderDto> orders = OrderService.showOrders(tableNumber);
        OutputView.printOrders(orders);
    }

    public static void emptyOrders(int tableNumber) {
        OrderRepository.deleteByTableNumber(tableNumber);
    }
}
