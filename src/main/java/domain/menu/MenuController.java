package domain.menu;

import domain.Validator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MenuController {
    private static final Validator validator = new Validator();

    public static void showMenus(List<Menu> menus) {
        OutputView.printMenus(menus);
    }

    public static int readNumber() {
        int menuNumber = getInputMenuNumber();
        return menuNumber;
    }

    public static int readCount() {
        int menuCount = getInputMenuCount();
        return menuCount;
    }

    private static int getInputMenuNumber() {
        while(true) {
            try {
                String input = InputView.inputMenuNumber();
                return validator.validateMenuNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static int getInputMenuCount() {
        while(true) {
            try {
                String input = InputView.inputMenuCount();
                return validator.validateMenuCount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
