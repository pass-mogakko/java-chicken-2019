package controller;

import domain.order.OrderedMenus;
import service.OrderService;
import service.PayService;
import view.InputView;
import view.OutputView;
import view.resource.PayTypeCommand;

public class PayController {

    private final OrderService orderService;
    private final PayService payService;

    public PayController(OrderService orderService, PayService payService) {
        this.orderService = orderService;
        this.payService = payService;
    }

    public void receivePaymentRequest(int tableNumber) {
        OrderedMenus orderedMenus = orderService.getOrderByTable(tableNumber);
        OutputView.printOrder(DTOMapper.convert(orderedMenus));
        if (!orderedMenus.isEmpty()) {
            pay(tableNumber);
        }
    }

    private void pay(int tableNumber) {
        PayTypeCommand payTypeCommand = InputView.inputPayTypeCommand(tableNumber);
        int totalPayment = payService.calculateTotalPayment(tableNumber, DTOMapper.convert(payTypeCommand));
        OutputView.printTotalPayment(totalPayment);
        payService.completePayment(tableNumber);
    }
}
