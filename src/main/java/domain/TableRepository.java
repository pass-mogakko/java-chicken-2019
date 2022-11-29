package domain;

import constant.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {

    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static void menuOrder(int tableNumber, Menu menu, int orderQuantity) {
        Table table = findTableByNumber(tableNumber);
        table.menuOrder(menu, orderQuantity);
    }

    public static Table findTableByNumber(int tableNumber) {
        return tables.stream()
                .filter(table -> table.isSameNumber(tableNumber))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_TABLE));
    }

    public static void validateEmptyTable(int tableNumber) {
        Table table = findTableByNumber(tableNumber);
        if (table.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_TABLE);
        }
    }
}
