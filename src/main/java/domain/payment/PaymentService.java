package domain.payment;

import domain.order.Order;
import domain.order.OrderRepository;
import domain.table.Table;
import domain.table.TableRepository;

import java.util.List;

import static domain.ErrorCode.TABLE_NOT_FOUND;

public class PaymentService {

    public static Payment createPayment(int tableNumber, int command) {
        Table table = TableRepository.findByNumber(tableNumber);
        if (table == null) {
            throw new IllegalArgumentException(TABLE_NOT_FOUND.getMessage());
        }
        List<Order> orders = OrderRepository.findAllByTableNumber(tableNumber);
        Method method = determineMethod(command);

        return new Payment(table, orders, method);
    }

    public static void getTotalPrice(Payment payment) {
        int totalPrice = payment.calculateTotalPrice();

    }

    private static Method determineMethod(int command) {
        if (command == 1) {
            return Method.CARD;
        }
        return Method.CASH;
    }
}
