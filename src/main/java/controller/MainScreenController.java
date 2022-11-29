package controller;

import domain.MainScreenSelection;
import java.util.List;
import service.MainScreenService;
import view.OutputView;

public class MainScreenController {

    private static final MainScreenController mainController = new MainScreenController();
    private static final MainScreenService mainScreenService = MainScreenService.getInstance();

    private MainScreenController() {

    }

    public static MainScreenController getInstance() {
        return mainController;
    }

    public void run() {
        List<MainScreenSelection> allMainScreenSelection = MainScreenSelection.findAllMainScreenSelection();
        OutputView.printMainScreen(allMainScreenSelection);
        //        final int tableNumber = InputView.inputTableNumber();
        //        try {
        //            MainScreenSelection.validateInput(tableNumber);
        //        } catch (IllegalArgumentException e) {
        //            System.out.printf(ErrorMessage.ERROR_MESSAGE_FORM, e.getMessage());
        //            run();
        //        }
    }
}
