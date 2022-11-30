package service;

import domain.Table;
import domain.TableRepository;

import java.util.List;

public class TableService {

    public List<Table> getAllTables() {
        return TableRepository.tables();
    }
}
