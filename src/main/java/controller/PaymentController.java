package controller;

import domain.Table;
import domain.TableRepository;
import java.util.List;
import view.InputView;
import view.OutputView;

public class PaymentController {

    public static void run() {
        int paymentTableNumber = requestPaymentTableNumber();
    }

    private static int requestPaymentTableNumber() {
        List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        int orderTableNumber = InputView.requestOrderTableNumber();
        //        try {
        //            TablesNumber.validate(orderTableNumber);
        //        } catch (IllegalArgumentException e) {
        //            OutputView.printErrorMessage(e.getMessage());
        //            requestPaymentTableNumber();
        //        }
        //        return orderTableNumber;
        return 0;
    }
}
