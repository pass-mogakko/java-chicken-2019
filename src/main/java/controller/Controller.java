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
            OutputView.printTables(tables);
            int tableNumber = getInputTableNumber();
            getInputMenuNumber();
        }

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    private int getInputCommand() {
        while (true) {
            try {
                String input = InputView.inputCommand();
                return validator.validateCommand(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getInputTableNumber() {
        while (true) {
            try {
                String input = InputView.inputTableNumber();
                return validator.validateTableNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getInputMenuNumber() {
        String input = InputView.inputMenuNumber();
        return input;
    }

}
