package controller;

import domain.MainScreenSelection;
import java.util.List;
import view.InputView;
import view.OutputView;

public class MainScreenController {

    private static final MainScreenController mainController = new MainScreenController();

    private MainScreenController() {

    }

    public static MainScreenController getInstance() {
        return mainController;
    }

    public static void run() {
        List<MainScreenSelection> allMainScreenSelection = MainScreenSelection.findAllMainScreenSelection();
        OutputView.printMainScreen(allMainScreenSelection);
        int mainScreenSelection = InputView.requestMainScreenSelection();
        try {
            MainScreenSelection selection = MainScreenSelection.findClassBySelection(mainScreenSelection);
            selection.doNextAction();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            run();
        }

    }
}
