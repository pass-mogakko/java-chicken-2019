package service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    private final OrderService orderService = new OrderService();

    @DisplayName("주문 등록: 테이블 번호 예외 발생")
    @Test
    void updateTableOrderWithInvalidTable() {
        assertThatThrownBy(() -> orderService.updateTableOrder(100, 1, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 등록: 메뉴 번호 예외 발생")
    @Test
    void updateTableOrderWithInvalidMenu() {
        assertThatThrownBy(() -> orderService.updateTableOrder(1, 100, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("주문 등록: 주문 수량 예외 발생")
    @Test
    void updateTableOrderWithInvalidAmount() {
        orderService.updateTableOrder(1, 1, 3);

        assertThatThrownBy(() -> orderService.updateTableOrder(1, 1, 97))
                .isInstanceOf(IllegalArgumentException.class);
    }
}