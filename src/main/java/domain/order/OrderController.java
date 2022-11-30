package domain.order;

import domain.dto.OrderDto;
import domain.menu.Menu;
import domain.menu.MenuController;
import domain.table.Table;
import domain.table.TableController;
import view.OutputView;

import java.util.List;

public class OrderController {

    public static void createOrder(int tableNumber, int menuNumber, int menuCount) {
        OrderService.createOrder(tableNumber, menuNumber, menuCount);
        OutputView.printOrderCompleteMessage();
    }

    public static void showOrders(int tableNumber){
        List<domain.dto.OrderDto> orders = OrderService.showOrders(tableNumber);
        OutputView.printOrders(orders);

    }

}
