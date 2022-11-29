package domain;

import java.util.List;

public class Order {
    private final int tableNumber;
    private final int menuNumber;
    private final int quantity;
    static final List<Payment> payments = PaymentRepository.payments();

    public Order(final int tableNumber, final int menuNumber, final int quantity) {
        this.tableNumber = tableNumber;
        this.menuNumber = menuNumber;
        this.quantity = quantity;
    }

    public void registerOrder() {
        Table table = new Table(tableNumber);
        final int menuPrice = MenuRepository.getPrice(menuNumber);
        final int payment = quantity * menuPrice;

    }

}
