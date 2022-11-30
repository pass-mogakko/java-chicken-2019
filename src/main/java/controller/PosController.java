package controller;

import service.MenuService;
import service.OrderService;
import service.PayService;
import service.TableService;
import view.InputView;
import view.OutputView;

public class PosController {

    private final TableService tableService = new TableService();
    private final MenuService menuService = new MenuService();
    private final OrderService orderService = new OrderService();
    private final PayService payService = new PayService();

    public void run() {
        while (true) {
            showServices();
            int selectNumber = InputView.inputServiceNumber();
            doSelectedService(selectNumber);
            if (selectNumber == 3) {
                exit();
                return;
            }
        }
    }

    private void showServices() {
        OutputView.printMain();
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
        OutputView.printTables(tableService.getAllTables());
        int tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menuService.getAllMenus());
        int menuNumber = InputView.inputMenuNumber();
        // TODO 수량 받기
        // TODO orderService에서 주문 등록하기 + order() 메소드 단위로 예외처리
    }

    private void pay() {
        // TODO 결제 서비스
    }

    private void exit() {
        // TODO 프로그램 종료 메시지 출력
    }
}
