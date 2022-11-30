package domain.table;

import java.util.Optional;

import static domain.ErrorCode.*;

public class TableService {

    public static void updateTable(int tableNumber) {
        if (!isPresentTable(tableNumber)) {
            TableRepository.save(new Table(tableNumber));
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
