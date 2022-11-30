import domain.Validator;
import domain.menu.Menu;
import domain.menu.MenuController;
import domain.menu.MenuRepository;
import domain.order.OrderController;
import domain.payment.PaymentController;
import domain.table.Table;
import domain.table.TableController;
import domain.table.TableRepository;
import view.InputView;

import java.util.List;

public class Machine {
    private final List<Table> tables;
    private final List<Menu> menus;

    private final Validator validator = new Validator();

    public Machine() {
        this.tables = TableRepository.tables();
        this.menus =  MenuRepository.menus();
    }

    public void run() {
        int command = getInputCommand();
        while (command != 3) {
            if (command == 1)
                order();
            if (command == 2)
                PaymentController.makePayment(tables);
            command = getInputCommand();
        }
    }

    private void order() {
        int tableNumber = TableController.readNumberToOrder(tables);
        TableController.updateTable(tableNumber);

        MenuController.showMenus(menus);
        int menuNumber = MenuController.readNumber();
        int menuCount = MenuController.readCount();

        OrderController.createOrder(tableNumber, menuNumber, menuCount);
    }

    private int getInputCommand() {
        while (true) {
            try {
                String input = InputView.inputCommand();
                return validator.validateCommand(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}