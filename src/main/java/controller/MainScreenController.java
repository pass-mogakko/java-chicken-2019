package controller;

public class MainScreenController {

    private static final MainScreenController mainController = new MainScreenController();

    private MainScreenController() {

    }

    public static MainScreenController getInstance() {
        return mainController;
    }

    public void run() {

    }
}
