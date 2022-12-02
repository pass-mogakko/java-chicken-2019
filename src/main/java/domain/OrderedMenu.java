package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderedMenu {
    private final HashMap<Menu, Integer> orderedMenu;

    public OrderedMenu() {
        this.orderedMenu = new HashMap<>();
        initOrderedMenu();
    }

    public void register(final Order order) {
        final Menu menu = order.getMenu();
        final int currentQuantity = orderedMenu.get(menu);
        final int quantity = order.getQuantity();
        orderedMenu.put(menu, currentQuantity + quantity);
    }

    public List<Order> getOrder() {
        List<Order> orders = new ArrayList<>();
        for (Menu menu : orderedMenu.keySet()) {
            Order order = new Order(menu, orderedMenu.get(menu));
            orders.add(order);
        }
        return orders;
    }

    public void initOrderedMenu() {
        List<Menu> menus = MenuRepository.menus();
        for (Menu menu : menus) {
            orderedMenu.put(menu, 0);
        }
    }
}
