package controller;

import service.MenuService;
import service.OrderService;
import view.InputView;
import view.OutputView;

public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void receiveOrder(int tableNumber) {
        OutputView.printMenus(MenuService.getAllMenus());
        int menuNumber = InputView.inputMenuNumber();
        int menuAmount = InputView.inputMenuQuantity();
        orderService.addTableOrder(tableNumber, menuNumber, menuAmount);
    }
}
