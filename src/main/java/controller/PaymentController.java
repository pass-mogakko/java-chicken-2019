package controller;

import domain.Table;
import domain.TableRepository;
import domain.TablesNumber;
import java.util.List;
import view.InputView;
import view.OutputView;

public class PaymentController {

    public static void run() {
        int paymentTableNumber = requestPaymentTableNumber();
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

    private static void requestPaymentMethod(int paymentTableNumber) {
        try {
            TableRepository.validateEmptyTable(paymentTableNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            MainScreenController.run();
            return;
        }
    }
}
