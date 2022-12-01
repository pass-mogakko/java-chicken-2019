package controller;

import static view.resource.Main.ORDER;
import static view.resource.Main.PAY;

import service.MenuService;
import service.TableService;
import view.InputView;
import view.OutputView;
import view.resource.PayTypeCommand;

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
        OutputView.printTables(DTOMapper.convert(tableService.getAllTables()));
        int tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menuService.getAllMenus());
        int menuNumber = InputView.inputMenuNumber();
        int menuAmount = InputView.inputMenuAmount();
        tableService.addTableOrder(tableNumber, menuNumber, menuAmount);
        // TODO 예외 발생 시 order() 다시 실행
    }

    private void pay() {
        OutputView.printTables(DTOMapper.convert(tableService.getAllTables()));
        int tableNumber = InputView.inputTableNumber();
        OutputView.printOrder(DTOMapper.convert(tableService.getOrderByTable(tableNumber)));
        PayTypeCommand payTypeCommand = InputView.inputPayTypeCommand(tableNumber);
        int totalPayment = tableService.payOrderByTable(tableNumber, DTOMapper.convert(payTypeCommand));
        OutputView.printTotalPayment(totalPayment);
        // TODO 예외 발생 시 pay() 다시 실행
    }

    private void exit() {
        // TODO 프로그램 종료 메시지 출력
    }
}
