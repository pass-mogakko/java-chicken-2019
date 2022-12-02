package controller;

import service.TableService;
import view.InputView;
import view.OutputView;
import view.resource.PayTypeCommand;

public class PayController {

    private final TableService tableService;

    public PayController(TableService tableService) {
        this.tableService = tableService;
    }

    public void pay(int tableNumber) {
        OutputView.printOrder(DTOMapper.convert(tableService.getOrderByTable(tableNumber)));
        PayTypeCommand payTypeCommand = InputView.inputPayTypeCommand(tableNumber);
        int totalPayment = tableService.calculateTotalPayment(tableNumber, DTOMapper.convert(payTypeCommand));
        OutputView.printTotalPayment(totalPayment);
        tableService.completePayment(tableNumber);
    }
}
