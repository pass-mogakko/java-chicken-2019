package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final List<Table> tables;

    public Controller() {
        this.tables = TableRepository.tables();
    }

    public void run() {
        String input = InputView.inputCommand();

        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }
}
