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
        while (command != 3) {
            if (command == 1)
                order();
            if (command == 2)
                makePayment();
            command = getInputCommand();
        }
    }

    private void order() {
        OutputView.printTables(tables);
        int tableNumber = getInputTableNumberToOrder();
        OutputView.printMenus(menus);
        int menuNumber = getInputMenuNumber();
        int menuCount = getInputMenuCount();
    }

    private void makePayment() {
        OutputView.printTables(tables);
        int tableNumber = getInputTableNumberToPay();
        // 주문한 테이블인지 확인하기
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

    private int getInputTableNumberToOrder() {
        while (true) {
            try {
                String input = InputView.inputTableNumberToOrder();
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

    private int getInputMenuCount() {
        while(true) {
            try {
                String input = InputView.inputMenuCount();
                return validator.validateMenuCount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getInputTableNumberToPay() {
        while (true) {
            try {
                String input = InputView.inputTableNumberToPay();
                return validator.validateTableNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
