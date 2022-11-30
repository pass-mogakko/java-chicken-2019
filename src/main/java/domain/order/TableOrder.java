package domain.order;

import static domain.PayStatus.PENDING;

import domain.PayStatus;

import java.util.UUID;

public class TableOrder {

    private final String id = UUID.randomUUID().toString();
    private final int tableNumber;
    private final Order order;
    private PayStatus status = PENDING;

    public TableOrder(int tableNumber, Order order) {
        this.tableNumber = tableNumber;
        this.order = order;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public Order getOrder() {
        return order;
    }

    public boolean isPending() {
        return status == PENDING;
    }

    public void addOrder(OrderedMenu orderedMenu) {
        order.addOrderedMenu(orderedMenu);
    }

    // TODO 결제 상태 변경

    // TODO id 반환, id로 DTO 조회
}
