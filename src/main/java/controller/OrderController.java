package controller;

import service.MenuService;
import service.TableService;
import view.InputView;
import view.OutputView;

public class OrderController {

    private final TableService tableService;
    private final MenuService menuService;

    public OrderController(TableService tableService, MenuService menuService) {
        this.tableService = tableService;
        this.menuService = menuService;
    }

    public void receiveOrder(int tableNumber) {
        OutputView.printMenus(menuService.getAllMenus());
        int menuNumber = InputView.inputMenuNumber();
        int menuAmount = InputView.inputMenuAmount();
        tableService.addTableOrder(tableNumber, menuNumber, menuAmount);
    }
}
