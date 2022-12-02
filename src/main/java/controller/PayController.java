package controller;

import domain.order.OrderedMenus;
import service.TableService;
import view.InputView;
import view.OutputView;
import view.resource.PayTypeCommand;

public class PayController {

    private final TableService tableService;

    public PayController(TableService tableService) {
        this.tableService = tableService;
    }

    public void receivePaymentRequest(int tableNumber) {
        OrderedMenus orderedMenus = tableService.getOrderByTable(tableNumber);
        OutputView.printOrder(DTOMapper.convert(orderedMenus));
        if (!orderedMenus.isEmpty()) {
            pay(tableNumber);
        }
    }

    private void pay(int tableNumber) {
        PayTypeCommand payTypeCommand = InputView.inputPayTypeCommand(tableNumber);
        int totalPayment = tableService.calculateTotalPayment(tableNumber, DTOMapper.convert(payTypeCommand));
        OutputView.printTotalPayment(totalPayment);
        tableService.completePayment(tableNumber);
    }
}
