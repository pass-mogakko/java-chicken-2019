package domain;

import domain.order.Order;
import domain.order.OrderedMenus;

public class Table {

    private final int number;
    private final Order order = new Order();

    public Table(int number) {
        this.number = number;
    }

    public void updateOrder(int menuNumber, int quantity) {
        order.update(menuNumber, quantity);
    }

    public void completeOrder() {
        order.complete();
    }

    public int getNumber() {
        return number;
    }

    public boolean hasOrder() {
        return !order.isEmpty();
    }

    public OrderedMenus getOrderMenus() {
        return order.getMenus();
    }

    public int getTotalPrice() {
        if (!hasOrder()) {
            throw new IllegalStateException("결제할 주문 내역이 존재하지 않습니다.");
        }
        return order.getTotalPrice();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
