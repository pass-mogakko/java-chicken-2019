package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Category;
import domain.Menu;
import domain.TableRepository;
import domain.order.OrderedMenus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class OrderServiceTest {

    private static final Menu menuForNo1 = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
    private final OrderService orderService = OrderService.getInstance();

    @DisplayName("주문 등록: 테이블 번호 예외 발생")
    @Test
    void addTableOrderWithInvalidTable() {
        assertThatThrownBy(() -> orderService.addTableOrder(100, 1, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 등록: 메뉴 번호 예외 발생")
    @Test
    void updateOrderWithInvalidMenu() {
        assertThatThrownBy(() -> orderService.addTableOrder(1, 100, 1));
    }

    @DisplayName("주문 조회: 테이블 번호로 조회")
    @Test
    void getOrderByTable() {
        TableRepository.tables()
                .get(0).updateOrder(menuForNo1, 1);
        OrderedMenus orderedMenus = orderService.getOrderByTable(1);
        Map<Menu, Integer> quantityByMenus = orderedMenus.getQuantityByMenus();

        assertThat(quantityByMenus).hasSize(1);
        assertThat(quantityByMenus.get(menuForNo1)).isEqualTo(1);
    }

    @DisplayName("주문 조회: 주문이 없는 테이블 번호로 조회")
    @Test
    void getEmptyOrderByTable() {
        OrderedMenus orderedMenus = orderService.getOrderByTable(3);
        Map<Menu, Integer> quantityByMenus = orderedMenus.getQuantityByMenus();

        assertThat(quantityByMenus).isEmpty();
    }

    @DisplayName("주문 조회: 테이블 번호 예외 발생")
    @Test
    void getOrderByInvalidTable() {
        assertThatThrownBy(() -> orderService.getOrderByTable(100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}