package domain;

public class Quantity {
    private static final int QUANTITY_START_LIMIT = 1;
    private static final int QUANTITY_END_LIMIT = 99;

    public static int validateQuantity(final int quantity) {
        if (quantity < QUANTITY_START_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 1개 이상의 수량을 입력해주세요.");
        }
        if (quantity > QUANTITY_END_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 최대 주문 수량은 99개 입니다.");
        }
        return quantity;
    }
}
