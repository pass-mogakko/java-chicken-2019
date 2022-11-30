package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

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

    public static Table getTableByNumber(int number) {
        return findTable(table -> table.getNumber() == number);
    }

    private static Table findTable(Predicate<Table> condition) {
        return tables.stream()
                .filter(condition)
                .findFirst()
                .orElseThrow(() -> {throw new IllegalArgumentException("해당 테이블이 존재하지 않습니다.");});
    }
}
