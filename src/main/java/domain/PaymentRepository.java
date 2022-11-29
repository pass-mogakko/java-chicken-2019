package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaymentRepository {
    private static final List<Table> tables = TableRepository.tables();
    private static final List<Payment> payments = new ArrayList<>();

    static{
        for(Table table : tables){
            payments.add(new Payment(table, 0));
        }
    }

    public static List<Payment> payments() {
        return Collections.unmodifiableList(payments);
    }
}
