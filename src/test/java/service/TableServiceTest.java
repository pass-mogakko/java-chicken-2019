package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.TableRepository;
import dto.OrderedMenuDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
//        tableService.addTableOrder(1, 1, 3);

        assertThatThrownBy(() -> tableService.addTableOrder(1, 1, 99))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 조회: 테이블 번호로 조회")
    @Test
    void getOrderByTable() {
//        tableService.addTableOrder(1, 1, 1);
        List<OrderedMenuDTO> orderedMenus = tableService.getOrderByTable(1);

        assertThat(orderedMenus).hasSize(1);
        assertThat(orderedMenus.get(0).getQuantity()).isEqualTo(1);
    }

    @DisplayName("주문 조회: 주문이 없는 테이블 번호로 조회")
    @Test
    void getEmptyOrderByTable() {
//        tableService.addTableOrder(1, 1, 1);

        assertThat(tableService.getOrderByTable(3)).isEmpty();
    }

    @DisplayName("주문 조회: 테이블 번호 예외 발생")
    @Test
    void getOrderByInvalidTable() {
//        tableService.addTableOrder(1, 1, 1);

        assertThatThrownBy(() -> tableService.getOrderByTable(100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}