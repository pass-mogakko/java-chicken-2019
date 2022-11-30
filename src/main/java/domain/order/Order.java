package domain.order;

import domain.menu.Menu;
import domain.table.Table;

import java.util.Optional;

public class Order {
    private Optional<Table> table;
    private Menu menu;
    private int count;

    public Order(Optional<Table> table, Menu menu, int count) {
        this.table = table;
        this.menu = menu;
        this.count = count;
    }

    public boolean isEqualTable(Optional<Table> table) {
        if (this.table.equals(table)) {
            return true;
        }
        return false;
    }
}
