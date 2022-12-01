package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.PayType;
import domain.TableRepository;
import domain.order.OrderedMenus;
import dto.PayTypeDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class TableServiceTest {

    private static final TableService tableService = new TableService();

    @BeforeAll
    static void initializeTableOrder() {
        TableRepository.tables()
                .get(0).updateOrder(1, 1);
    }

    @DisplayName("주문 등록: 테이블 번호 예외 발생")
    @Test
    void addTableOrderWithInvalidTable() {
        assertThatThrownBy(() -> tableService.addTableOrder(100, 1, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 등록: 메뉴 번호 예외 발생")
    @Test
    void addTableOrderWithInvalidMenu() {
        assertThatThrownBy(() -> tableService.addTableOrder(1, 100, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("주문 등록: 주문 수량 예외 발생")
    @Test
    void addTableOrderWithInvalidAmount() {
        assertThatThrownBy(() -> tableService.addTableOrder(1, 1, 99))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 조회: 테이블 번호로 조회")
    @Test
    void getOrderByTable() {
        OrderedMenus orderedMenus = tableService.getOrderByTable(1);
        Map<Integer, Integer> quantityByMenus = orderedMenus.getQuantityByMenus();

        assertThat(quantityByMenus).hasSize(1);
        assertThat(quantityByMenus.get(1)).isEqualTo(1);
    }

    @DisplayName("주문 조회: 주문이 없는 테이블 번호로 조회")
    @Test
    void getEmptyOrderByTable() {
        OrderedMenus orderedMenus = tableService.getOrderByTable(3);
        Map<Integer, Integer> quantityByMenus = orderedMenus.getQuantityByMenus();

        assertThat(quantityByMenus).isEmpty();
    }

    @DisplayName("주문 조회: 테이블 번호 예외 발생")
    @Test
    void getOrderByInvalidTable() {
        assertThatThrownBy(() -> tableService.getOrderByTable(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("결제: 결제 유형에 따라 할인 적용")
    @Test
    void payOrderByTable() {
        assertThat(tableService.payOrderByTable(1, new PayTypeDTO(PayType.CARD)))
                .isEqualTo(16_000);

        tableService.addTableOrder(1, 1, 1);
        assertThat(tableService.payOrderByTable(1, new PayTypeDTO(PayType.CASH))).isEqualTo(15_200);
    }

    @DisplayName("결제: 테이블 번호 예외 발생")
    @Test
    void payOrderByInvalidTable() {
        assertThatThrownBy(() -> tableService.payOrderByTable(100, new PayTypeDTO(PayType.CARD)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("결제: 주문이 없는 테이블 번호 예외 발생")
    @Test
    void payOrderByEmptyOrderTable() {
        assertThatThrownBy(() -> tableService.payOrderByTable(3, new PayTypeDTO(PayType.CARD)))
                .isInstanceOf(IllegalStateException.class);
    }
}