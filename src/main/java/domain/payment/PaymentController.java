package domain.payment;

import domain.Validator;
import domain.dto.OrderDto;
import domain.order.OrderController;
import domain.order.OrderService;
import domain.table.Table;
import domain.table.TableController;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PaymentController {
    private static final Validator validator = new Validator();

    public static void makePayment(List<Table> tables) {
        int tableNumber = TableController.readNumberToPay(tables);
        PaymentService.makePayment(tableNumber);
        OrderController.showOrders(tableNumber);

        int payment = readPaymentNumber(tableNumber);
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
