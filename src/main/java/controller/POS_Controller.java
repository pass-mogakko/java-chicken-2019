package controller;

import domain.Command;
import view.InputView;
import view.OutputView;

import static domain.Command.readInputCommand;

public class POS_Controller {
    final OrderController orderController = new OrderController();
    final PaymentController paymentController = new PaymentController();

    public void run() {
        int command = readCommand();
        if (Command.isOrderRegistration(command)) {
            orderController.run();
            run();
        }
        if (Command.isPayment(command)) {
            paymentController.run();
            run();
        }
        if (Command.isExit(command)) {
            OutputView.printExitMessage();
        }
    }

    private static int readCommand() {
        OutputView.printMainView();
        try {
            int command = InputView.inputCommand();
            return readInputCommand(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCommand();
        }
    }
}
