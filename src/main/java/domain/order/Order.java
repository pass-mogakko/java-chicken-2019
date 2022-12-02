package domain.order;

import static domain.order.OrderStatus.EMPTY;
import static domain.order.OrderStatus.PENDING;

import domain.Menu;

public class Order {

    private final OrderedMenus menus = new OrderedMenus();
    private OrderStatus status = EMPTY;

    public OrderedMenus getMenus() {
        return menus;
    }

    public void update(Menu menu, int quantity) {
        menus.add(menu, quantity);
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
