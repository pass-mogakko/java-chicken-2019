package service;

import domain.Table;
import domain.TableRepository;

import java.util.List;

public class TableService {

    public List<Table> getAllTables() {
        List<Table> tables = TableRepository.tables();
        DataValidator.validateNullOrEmpty(tables);
        return tables;
    }
}
