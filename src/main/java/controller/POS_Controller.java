package controller;

import domain.Command;
import view.InputView;
import view.OutputView;

import static domain.Command.readInputCommand;

public class POS_Controller {
    public void run() {
        int command = readCommand();
        while (!Command.isExit(command)) {
            if (Command.isOrderRegistration(command)) {
                //주문 저장 컨트롤러
            }
            if (Command.isPayment(command)) {
                // 결제 컨트롤러
            }
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
