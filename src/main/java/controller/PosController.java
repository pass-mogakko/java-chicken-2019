package controller;

import static view.resource.MainCommand.EXIT;
import static view.resource.MainCommand.ORDER;
import static view.resource.MainCommand.PAY;

import service.MenuService;
import service.TableService;
import view.InputView;
import view.OutputView;
import view.resource.MainCommand;

public class PosController {

    private final TableService tableService = TableService.getInstance();
    private final MenuService menuService = MenuService.getInstance();
    private final OrderController orderController = new OrderController(tableService, menuService);
    private final PayController payController = new PayController(tableService);

    public void run() {
        MainCommand mainCommand = selectService();
        if (mainCommand != EXIT) {
            doSelectedService(mainCommand);
            run();
        }
        exit();
    }

    private MainCommand selectService() {
        OutputView.printMain();
        return InputView.inputServiceNumber();
    }

    private void doSelectedService(MainCommand mainCommand) {
        int tableNumber = selectTable();
        if (mainCommand == ORDER) {
            orderController.receiveOrder(tableNumber);
        }
        if (mainCommand == PAY) {
            payController.receivePaymentRequest(tableNumber);
        }
    }

    private int selectTable() {
        OutputView.printTables(DTOMapper.convert(tableService.getAllTables()));
        return InputView.inputTableNumber();
    }

    private void exit() {
        OutputView.printExitMessage();
    }
}
