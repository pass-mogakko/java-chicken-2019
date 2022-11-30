package domain.order;

import domain.dto.OrderDto;
import domain.menu.Menu;
import domain.table.Table;

public class Order {
    private Table table;
    private Menu menu;
    private int count;

    public Order(Table table, Menu menu, int count) {
        this.table = table;
        this.menu = menu;
        this.count = count;
    }

    public boolean isEqualTable(Table table) {
        if (this.table.equals(table)) {
            return true;
        }
        return false;
    }

    public Table getTable() {
        return table;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
    }

    OrderDto makeDto() {
        return new OrderDto.Builder()
                .menuName(menu.getName())
                .count(count)
                .price(menu.getPrice())
                .build();
    }
}
