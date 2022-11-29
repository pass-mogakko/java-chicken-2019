package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final List<Table> tables;

    private final TypeConverter converter = new TypeConverter();
    private final Validator validator = new Validator();

    public Controller() {
        this.tables = TableRepository.tables();
    }

    public void run() {
        int command = getInputCommand();


        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    private int getInputCommand() {
        String input = InputView.inputCommand();
        int command = converter.convertStringToInt(input);
        validator.validateCommandRange(command);
        return command;
    }
}
