package service;

import domain.Table;
import domain.TableRepository;

import java.util.List;

public class TableService {

    public List<Table> getAllTables() {
        List<Table> tables = TableRepository.tables();
        return tables;
    }

    public void addTableOrder(int tableNumber, int menuNumber, int quantity) {
        Table tableForOrder = TableRepository.getTableByNumber(tableNumber);
        tableForOrder.updateOrder(menuNumber, quantity);
    }
}
