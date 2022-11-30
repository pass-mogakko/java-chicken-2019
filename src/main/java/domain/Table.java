package domain;

import domain.order.Order;

public class Table {

    private final int number;
    private final Order order = new Order();

    public Table(int number) {
        this.number = number;
    }

    public void updateOrder(int menuNumber, int quantity) {
        order.update(menuNumber, quantity);
    }

    public void payOrder() {
        // TODO Order Empty 검증
        // TODO 결제 로직
        // TODO 결제 상태를 완료로 변경
        order.complete();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
