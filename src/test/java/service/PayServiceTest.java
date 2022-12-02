package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Category;
import domain.Menu;
import domain.PayType;
import domain.TableRepository;
import dto.PayTypeDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PayServiceTest {

    private static final Menu menuForNo1 = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
    private final PayService payService = PayService.getInstance();

    @BeforeEach
    void initializeTableOrder() {
        TableRepository.tables()
                .get(0).updateOrder(menuForNo1, 1);
    }

    @AfterEach
    void resetTableOrder() {
        payService.completePayment(1);
    }

    @DisplayName("결제: 카드 결제 할인율 적용")
    @Test
    void payCardOrderByTable() {
        assertThat(payService.calculateTotalPayment(1, new PayTypeDTO(PayType.CARD)))
                .isEqualTo(16_000);
    }

    @DisplayName("결제: 현금 결제 할인율 적용")
    @Test
    void payCashOrderByTable() {
        assertThat(payService.calculateTotalPayment(1, new PayTypeDTO(PayType.CASH)))
                .isEqualTo(15_200);
    }

    @DisplayName("결제: 테이블 번호 예외 발생")
    @Test
    void payOrderByInvalidTable() {
        assertThatThrownBy(() -> payService.calculateTotalPayment(100, new PayTypeDTO(PayType.CARD)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("결제: 주문이 없는 테이블 번호 예외 발생")
    @Test
    void payOrderByEmptyOrderTable() {
        assertThatThrownBy(() -> payService.calculateTotalPayment(3, new PayTypeDTO(PayType.CARD)))
                .isInstanceOf(IllegalStateException.class);
    }
}