package domain.order;

import static domain.order.OrderStatus.EMPTY;
import static domain.order.OrderStatus.PENDING;

public class Order {

    private final Menus menus = new Menus();
    private OrderStatus status = EMPTY;

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
