package controller;

import domain.Table;
import domain.TableRepository;
import domain.TablesNumber;
import java.util.List;
import service.OrderService;
import view.InputView;
import view.OutputView;

public class OrderController {

    private static final OrderController orderController = new OrderController();
    private static final OrderService orderService = OrderService.getInstance();

    private OrderController() {

    }

    public static OrderController getInstance() {
        return orderController;
    }

    public static void run() {
        List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        int orderTableNumber = InputView.requestOrderTableNumber();
        try {
            TablesNumber.validate(orderTableNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            run();
        }

    }

}
