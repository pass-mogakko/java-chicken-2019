package controller;

import domain.PaymentMethod;
import domain.Table;
import domain.TableRepository;
import domain.TablesNumber;
import java.util.List;
import view.InputView;
import view.OutputView;

public class PaymentController {

    public static void run() {
        int paymentTableNumber = requestPaymentTableNumber();
        boolean isEmptyTable = validateIsEmptyTable(paymentTableNumber);
        if (isEmptyTable) {
            return;
        }
        requestPaymentMethod(paymentTableNumber);

    }

    private static int requestPaymentTableNumber() {
        List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        int orderTableNumber = InputView.requestOrderTableNumber();
        try {
            TablesNumber.validate(orderTableNumber);
            return orderTableNumber;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestPaymentTableNumber();
        }
    }

    private static boolean validateIsEmptyTable(int paymentTableNumber) {
        try {
            TableRepository.validateEmptyTable(paymentTableNumber);
            return false;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            MainScreenController.run();
            return true;
        }
    }


    private static int requestPaymentMethod(int paymentTableNumber) {
        Table table = TableRepository.findTableByNumber(paymentTableNumber);
        OutputView.printOrderHistory(table);
        int paymentMethod = InputView.requestPaymentMethod(paymentTableNumber);
        try {
            PaymentMethod.validate(paymentMethod);
            return paymentMethod;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestPaymentMethod(paymentTableNumber);
        }
    }
}
