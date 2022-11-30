package domain.payment;

import domain.Validator;
import domain.dto.OrderDto;
import domain.order.OrderService;
import domain.table.Table;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PaymentController {
    private static final Validator validator = new Validator();

    public static void makePayment(List<Table> tables) {
        OutputView.printTables(tables);
        int tableNumber = readTableNumberToPay();
        PaymentService.makePayment(tableNumber);
        List<OrderDto> orders = OrderService.showOrders(tableNumber);
        OutputView.printOrders(orders);
        int payment = readPaymentNumber(tableNumber);
    }

    private static int readTableNumberToPay() {
        while (true) {
            try {
                String input = InputView.inputTableNumberToPay();
                return validator.validateTableNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int readPaymentNumber(int payment) {
        while (true) {
            try {
                String input = InputView.inputPaymentNumber(payment);
                return validator.validatePaymentNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
