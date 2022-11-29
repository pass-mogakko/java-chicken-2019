package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final List<Table> tables;
    private final List<Menu> menus;

    private final TypeConverter converter = new TypeConverter();
    private final Validator validator = new Validator();

    public Controller() {
        this.tables = TableRepository.tables();
        this.menus =  MenuRepository.menus();
    }

    public void run() {
        int command = getInputCommand();
        if (command == 1) {
            order();
        }
    }

    private void order() {
        OutputView.printTables(tables);
        int tableNumber = getInputTableNumber();
        OutputView.printMenus(menus);
        int menuNumber = getInputMenuNumber();
        getInputMenuCount();
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

    private int getInputMenuNumber() {
        while(true) {
            try {
                String input = InputView.inputMenuNumber();
                return validator.validateMenuNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private String getInputMenuCount() {
        while(true) {
            try {
                String input = InputView.inputMenuCount();
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
