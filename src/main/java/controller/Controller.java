package controller;

import domain.*;
import domain.dto.OrderDto;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.OrderService;
import domain.table.Table;
import domain.table.TableRepository;
import domain.table.TableService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final List<Table> tables;
    private final List<Menu> menus;

    private final Validator validator = new Validator();

    public Controller() {
        this.tables = TableRepository.tables();
        this.menus =  MenuRepository.menus();
    }

    public void run() {
        int command = getInputCommand();
        while (command != 3) {
            if (command == 1)
                makeOrder();
            if (command == 2)
                makePayment();
            command = getInputCommand();
        }
    }

    private void makeOrder() {
        OutputView.printTables(tables);
        int tableNumber = getInputTableNumberToOrder();
        TableService.updateTable(tableNumber);
        OutputView.printMenus(menus);
        int menuNumber = getInputMenuNumber();
        int menuCount = getInputMenuCount();
        OrderService.createOrder(tableNumber, menuNumber, menuCount);
        OutputView.printOrderCompleteMessage();
    }

    private void makePayment() {
        OutputView.printTables(tables);
        int tableNumber = getInputTableNumberToPay();
        TableService.makePayment(tableNumber);
        List<OrderDto> orders = OrderService.showOrders(tableNumber);
        OutputView.printOrders(orders);
        String payment = InputView.inputPaymentNumber(tableNumber);
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
