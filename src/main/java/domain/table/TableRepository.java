package domain.table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

//    static {
//        tables.add(new Table(1));
//        tables.add(new Table(2));
//        tables.add(new Table(3));
//        tables.add(new Table(5));
//        tables.add(new Table(6));
//        tables.add(new Table(8));
//    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static void save(Table table) {
        tables.add(table);
    }

    public static Table findByNumber(int tableNumber) {
        if (tables.isEmpty())
            return null;
        for (Table table : tables) {
            if (table.isPresentNumber(tableNumber))
                return table;
        }
        return null;
    }
}
