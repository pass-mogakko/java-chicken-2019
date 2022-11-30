package domain.payment;

import domain.table.Table;
import domain.table.TableRepository;

import java.util.Optional;

import static domain.ErrorCode.TABLE_NOT_FOUND;

public class PaymentService {

    public static void makePayment(int tableNumber) {
        Optional<Table> table = TableRepository.findByNumber(tableNumber);
        if (table == null) {
            throw new IllegalArgumentException(TABLE_NOT_FOUND.getMessage());
        }
    }
}
