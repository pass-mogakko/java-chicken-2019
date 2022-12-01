package controller;

import static view.resource.Main.ORDER;
import static view.resource.Main.PAY;

import service.MenuService;
import service.TableService;
import view.InputView;
import view.OutputView;

public class PosController {

    private final TableService tableService = new TableService();
    private final MenuService menuService = new MenuService();

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
        if (selectNumber == ORDER.getNumber()) {
            order();
        }
        if (selectNumber == PAY.getNumber()) {
            pay();
        }
        // TODO 예외 발생
    }

    private void order() {
        OutputView.printTables(tableService.getAllTables());
        int tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menuService.getAllMenus());
        int menuNumber = InputView.inputMenuNumber();
        int menuAmount = InputView.inputMenuAmount();
        tableService.addTableOrder(tableNumber, menuNumber, menuAmount);
        // TODO 예외 발생 시 order() 다시 실행
    }

    private void pay() {
        // TODO 결제 서비스
        int tableNumber = InputView.inputTableNumber();
        // TODO 주문된 테이블 표시
        OutputView.printTables(tableService.getAllTables());
        // TODO 주문 목록 출력
        OutputView.printOrder(tableService.getOrderByTable(tableNumber));
    }

    private void exit() {
        // TODO 프로그램 종료 메시지 출력
    }
}
