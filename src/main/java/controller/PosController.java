package controller;

import static view.resource.MainCommand.EXIT;
import static view.resource.MainCommand.ORDER;
import static view.resource.MainCommand.PAY;

import service.OrderService;
import service.PayService;
import service.TableService;
import view.InputView;
import view.OutputView;
import view.resource.MainCommand;

public class PosController {

    private final OrderController orderController = new OrderController(OrderService.getInstance());
    private final PayController payController = new PayController(OrderService.getInstance(), PayService.getInstance());

    public void run() {
        try {
            runPos();
        } catch (Exception exception) {
            OutputView.printFunctionErrorMessage(exception.getMessage());
        }
    }

    private void runPos() {
        PosStatus status = PosStatus.RUN;
        while (status == PosStatus.RUN) {
            status = doSelectedService();
        }
    }

    private PosStatus doSelectedService() {
        MainCommand mainCommand = InputErrorHandler.runUntilGetLegalArguments(this::selectService);
        return InputErrorHandler.runUntilGetLegalArguments(this::doServiceByCommand, mainCommand);
    }

    private MainCommand selectService() {
        OutputView.printMain();
        return InputView.inputServiceNumber();
    }

    private PosStatus doServiceByCommand(MainCommand mainCommand) {
        if (mainCommand == EXIT) {
            exit();
            return PosStatus.STOP;
        }
        int tableNumber = selectTable();
        if (mainCommand == ORDER) {
            orderController.receiveOrder(tableNumber);
        }
        if (mainCommand == PAY) {
            payController.receivePaymentRequest(tableNumber);
        }
        return PosStatus.RUN;
    }

    private int selectTable() {
        OutputView.printTables(DTOMapper.convert(TableService.getAllTables()));
        return InputView.inputTableNumber();
    }

    private void exit() {
        OutputView.printExitMessage();
    }
}
