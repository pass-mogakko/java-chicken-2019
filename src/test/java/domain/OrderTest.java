package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
    @DisplayName("주문 저장")
    @Test
    public void registerOrderTest() {
        final Table table = new Table(2);
        final Menu menu = MenuRepository.findMenuByMenuNumber(2);
        final int quantity = 2;
        Order order = new Order(menu, quantity);

    }
}
