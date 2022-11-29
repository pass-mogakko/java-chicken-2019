package domain.table;

public class TableService {

    public static void updateTable(int tableNumber) {
        Table table = TableRepository.findByNumber(tableNumber);
        if (table == null) {
            TableRepository.save(table);
        }
    }
}
