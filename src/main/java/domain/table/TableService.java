package domain.table;

import static domain.ErrorCode.*;

public class TableService {

    public static void updateTable(int tableNumber) {
        Table table = TableRepository.findByNumber(tableNumber);
        if (table == null) {
            TableRepository.save(table);
        }
    }

    public static void makePayment(int tableNumber) {
        Table table = TableRepository.findByNumber(tableNumber);
        if (table == null) {
            throw new IllegalArgumentException(TABLE_NOT_FOUND.getMessage());
        }
    }
}
