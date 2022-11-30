package domain.table;

import java.util.Optional;

import static domain.ErrorCode.*;

public class TableService {

    public static void updateTable(int tableNumber) {
        if (!isPresentTable(tableNumber)) {
            TableRepository.save(new Table(tableNumber));
        }
    }

    public static void makePayment(int tableNumber) {
        if (!isPresentTable(tableNumber)) {
            throw new IllegalArgumentException(TABLE_NOT_FOUND.getMessage());
        }
    }

    private static boolean isPresentTable(int tableNumber) {
        Optional<Table> table = TableRepository.findByNumber(tableNumber);
        if (table == null) {
            return false;
        }
        return true;
    }
}
