package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.order.OrderedMenus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TableTest {

    private static final Menu menuForNo1 = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
    private static final Menu menuForNo2 = new Menu(2, "양념치킨", Category.CHICKEN, 16_000);

    @DisplayName("테이블 주문 등록")
    @Test
    void updateOrder() {
        Table table = new Table(1);
        table.updateOrder(menuForNo1, 1);
        table.updateOrder(menuForNo1, 1);
        table.updateOrder(menuForNo2, 1);

        OrderedMenus menus = table.getOrderMenus();
        assertThat(menus.getQuantityByMenus())
                .containsEntry(menuForNo1, 2)
                .containsEntry(menuForNo2, 1)
                .hasSize(2);
    }

    @DisplayName("주문 등록: 주문 수량 예외 발생")
    @Test
    void updateOrderWithInvalidAmount() {
        Table table = new Table(1);

        assertThatThrownBy(() -> table.updateOrder(menuForNo1, 100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("테이블 주문 내역 초기화")
    @Test
    void completeOrder() {
        Table table = new Table(1);
        table.updateOrder(menuForNo1, 1);
        table.completeOrder();

        assertThat(table.hasOrder()).isFalse();
    }

    @DisplayName("총 금액 계산: 수량에 따라 할인 적용")
    @Test
    void getTotalPrice() {
        Table table = new Table(1);
        table.updateOrder(menuForNo1, 9);
        assertThat(table.getTotalPrice()).isEqualTo(144_000);
        table.completeOrder();

        table.updateOrder(menuForNo1, 15);
        assertThat(table.getTotalPrice()).isEqualTo(225_000);

    }
}