package domain.order;

import static domain.order.OrderStatus.EMPTY;
import static domain.order.OrderStatus.PENDING;

public class Order {

    private final OrderedMenus menus = new OrderedMenus();
    private OrderStatus status = EMPTY;

    public OrderedMenus getMenus() {
        return menus;
    }

    public void update(int menuNumber, int quantity) {
        menus.add(menuNumber, quantity);
        status = PENDING;
    }

    public void complete() {
        menus.clear();
        status = EMPTY;
    }

    public int getTotalPrice() {
        return menus.getTotalPriceWithQuantityDiscount();
    }

    public boolean isEmpty() {
        return status == EMPTY;
    }
}
