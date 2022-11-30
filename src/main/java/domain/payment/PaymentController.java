package domain.payment;

import domain.Validator;
import view.InputView;


public class PaymentController {
    private static final Validator validator = new Validator();

    public static Payment createPayment(int tableNumber, int command) {
        return PaymentService.createPayment(tableNumber, command);
    }

    public static void getTotalPrice(Payment payment) {
        PaymentService.getTotalPrice(payment);
    }

    // 예외처리 - 컨트롤러에서 할지 고민 및 리팩토링 필요
    public static int readPaymentNumber(int payment) {
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
