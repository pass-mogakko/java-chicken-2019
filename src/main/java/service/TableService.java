package service;

import domain.Table;
import domain.TableRepository;
import domain.order.OrderedMenus;

import java.util.List;

public class TableService {

    public List<Table> getAllTables() {
        return TableRepository.tables();
    }

    public void addTableOrder(int tableNumber, int menuNumber, int quantity) {
        Table tableForOrder = TableRepository.getTableByNumber(tableNumber);
        tableForOrder.updateOrder(menuNumber, quantity);
    }

    public OrderedMenus getOrderByTable(int tableNumber) {
        Table table = TableRepository.getTableByNumber(tableNumber);
        return table.getOrderMenus();
    }
}
