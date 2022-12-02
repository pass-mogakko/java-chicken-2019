package domain;

import java.util.List;

public class Table {
    private final int number;
    private OrderedMenu orderedMenu;

    public Table(final int number) {
        this.number = number;
        this.orderedMenu = new OrderedMenu();
    }

    public int getNumber() {
        return number;
    }

    public boolean isSame(final int tableNumber) {
        return this.number == tableNumber;
    }

    public void addOrder(final Order order) {
        orderedMenu.register(order);
    }

    public void initOrder() {
        orderedMenu.initOrderedMenu();
    }

    public List<Order> getOrder() {
        return orderedMenu.getOrder();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
