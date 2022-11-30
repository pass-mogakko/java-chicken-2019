package controller;

import service.MenuService;
import service.OrderService;
import service.PayService;
import service.TableService;

public class PosController {

    private final TableService tableService = new TableService();
    private final MenuService menuService = new MenuService();
    private final OrderService orderService = new OrderService();
    private final PayService payService = new PayService();

    public void run() {
        while (true) {
            showServices();
            // TODO 서비스 번호 입력받기
            int selectNumber = 3;
            doSelectedService(selectNumber);
            if (selectNumber == 3) {
                exit();
            }
        }
    }

    private void showServices() {
        // TODO 서비스 목록 출력
    }

    private void doSelectedService(int selectNumber) {
        // TODO 서비스 번호 상수처리
        if (selectNumber == 1) {
            order();
        }
        if (selectNumber == 2) {
            pay();
        }
        // TODO 예외 발생
    }

    private void order() {
        // TODO 주문 등록 서비스
    }

    private void pay() {
        // TODO 결제 서비스
    }

    private void exit() {
        // TODO 프로그램 종료 메시지 출력
    }
}
