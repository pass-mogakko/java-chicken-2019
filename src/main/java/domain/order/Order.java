package domain.order;

import static domain.order.OrderStatus.EMPTY;
import static domain.order.OrderStatus.PENDING;

import java.util.Map;

public class Order {

    private final OrderedMenus menus = new OrderedMenus();
    private OrderStatus status = EMPTY;

    public Map<Integer, Integer> getMenus() {
        return menus.getQuantityByMenus();
    }

    public void update(int menuNumber, int quantity) {
        menus.add(menuNumber, quantity);
        status = PENDING;
    }

    public void complete() {
        menus.clear();
        status = EMPTY;
    }

    public boolean isEmpty() {
        return status == EMPTY;
    }
}
