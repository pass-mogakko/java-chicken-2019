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
        if (command == 1) {
            String tableNumber = getInputTableNumber();
        }

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    private int getInputCommand() {
        while (true) {
            try {
                String input = InputView.inputCommand();
                return validator.validateInputCommand(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getInputTableNumber() {
        OutputView.printTables(tables);
        String input = InputView.inputTableNumber();
        return input;
    }

}
