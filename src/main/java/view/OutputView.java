package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TABLE_INFO_MESSAGE = "## 테이블 목록";
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String MENU_INFO_MESSAGE = "## 메뉴 목록";

    public static void printTables(final List<Table> tables) {
        System.out.println();
        System.out.println(TABLE_INFO_MESSAGE);
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        System.out.println();
        System.out.println(MENU_INFO_MESSAGE);
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }
}
