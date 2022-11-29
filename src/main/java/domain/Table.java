package domain;

import java.util.List;

public class Table {
    private final int number;
    private static final List<Table> tables = TableRepository.tables();

    public Table(final int number) {
        this.number = number;
    }

    public int readTableNumber(){

        validateTableNumber();
        return readTableNumber();
    }

    private void validateTableNumber(){
        for(Table table : tables){

        }
    }

    public int getTableNumber(){
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
