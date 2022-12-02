package service;

import domain.Table;
import domain.TableRepository;

import java.util.List;

public class TableService {

    public static List<Table> getAllTables() {
        return TableRepository.tables();
    }

    public static Table getTableByNumber(int number) {
        return TableRepository.findTable(table -> table.getNumber() == number);
    }
}
