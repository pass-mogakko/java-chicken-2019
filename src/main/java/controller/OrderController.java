package controller;

import domain.Table;
import domain.TableRepository;
import java.util.List;
import view.OutputView;

public class OrderController {

    private static final OrderController orderController = new OrderController();

    private OrderController() {

    }

    public static OrderController getInstance() {
        return orderController;
    }

    public static void run() {
        List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
    }

}
