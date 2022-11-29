package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {

    private final int number;
    private final Map<Menu, Integer> menuAndQuantity = new HashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isSameNumber(int number) {
        return this.number == number;
    }

    public void menuOrder(Menu menu, int orderQuantity) {
        int menuOriginalQuantity = menuAndQuantity.getOrDefault(menu, 0);
        menuAndQuantity.put(menu, menuOriginalQuantity + orderQuantity);
    }

    public boolean isEmpty() {
        return menuAndQuantity.keySet()
                .stream()
                .map(menu -> menuAndQuantity.get(menu))
                .mapToInt(quantity -> quantity)
                .sum() == 0;
    }

    public String menuHistory() {
        StringBuilder stringBuilder = new StringBuilder();
        menuAndQuantity.keySet()
                .forEach(menu -> createMenuHistory(menu, stringBuilder));
        return stringBuilder.toString();
    }

    private void createMenuHistory(Menu menu, StringBuilder stringBuilder) {
        int quantity = menuAndQuantity.get(menu);
        if (quantity == 0) {
            return;
        }
        String menuHistory = menu.getName() + " " + quantity + " " + menu.getPrice() + "\n";
        stringBuilder.append(menuHistory);
    }
}
