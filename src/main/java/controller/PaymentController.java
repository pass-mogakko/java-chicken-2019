package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PaymentController {
    static final List<Table> tables = TableRepository.tables();

    public void run() {
        OutputView.printTables(tables);
        final Table table = readTable();
        final List<Order> tableOrder = table.getOrder();
        printOrderHistory(tableOrder);
        computePayment(table);
        table.initOrder();
    }

    private static Table readTable() {
        try {
            final int tableNumber = InputView.inputTableNumber();
            return TableRepository.findTableByNumber(tableNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readTable();
        }
    }

    private static PaymentMethod readPaymentMethod(final int tableNumber) {
        try {
            final int method = InputView.inputPaymentMethod(tableNumber);
            return PaymentMethod.validateMethod(method);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPaymentMethod(tableNumber);
        }
    }

    private void printOrderHistory(List<Order> tableOrder) {
        OutputView.printOrderHistoryMessage();
        for (Order order : tableOrder) {
            final String menuName = order.getMenuName();
            final int quantity = order.getQuantity();
            final int amount = order.getAmount();
            if (quantity > 0) {
                OutputView.printOrderHistory(menuName, quantity, amount);
            }
        }
    }

    private void computePayment(final Table table) {
        final List<Order> tableOrder = table.getOrder();
        final PaymentMethod method = readPaymentMethod(table.getNumber());
        Payment payment = new Payment(tableOrder, method);
        final double totalPayment = payment.getTotalPayment();
        OutputView.printTotalPrice(totalPayment);
    }
}
