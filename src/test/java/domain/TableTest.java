package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.order.OrderedMenus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TableTest {

    @DisplayName("테이블 주문 등록")
    @Test
    void updateOrder() {
        Table table = new Table(1);
        table.updateOrder(1, 1);
        table.updateOrder(1, 1);
        table.updateOrder(2, 1);

        OrderedMenus menus = table.getOrderMenus();
        assertThat(menus.getQuantityByMenus())
                .containsEntry(1, 2)
                .containsEntry(2, 1)
                .hasSize(2);
    }

    // TODO 주문 등록 관련 테스트 TableServiceTest에서 이 클래스로 이동

    @DisplayName("테이블 주문 내역 초기화")
    @Test
    void completeOrder() {
        Table table = new Table(1);
        table.updateOrder(1, 1);
        table.completeOrder();

        assertThat(table.hasOrder()).isFalse();
    }

    @DisplayName("총 금액 계산: 수량에 따라 할인 적용")
    @Test
    void getTotalPrice() {
        Table table = new Table(1);
        table.updateOrder(1, 9);
        assertThat(table.getTotalPrice()).isEqualTo(144_000);
        table.completeOrder();

        table.updateOrder(1, 15);
        assertThat(table.getTotalPrice()).isEqualTo(225_000);

    }
}