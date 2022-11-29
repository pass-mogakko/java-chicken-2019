package domain.order;

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
}
