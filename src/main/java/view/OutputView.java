package view;

import static view.resource.Format.TABLE_BOTTOM_LINE;
import static view.resource.Format.TABLE_FORMAT;
import static view.resource.Format.TABLE_TOP_LINE;

import domain.Menu;
import domain.Table;
import view.resource.Format;
import view.resource.Main;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public static void printMain() {
        System.out.println("## 메인화면");
        Arrays.stream(Main.values())
                .forEach(service -> System.out.printf(Format.MAIN_SERVICE.getValue(),
                        service.getNumber(), service.getName()));
        System.out.print(System.lineSeparator());
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TABLE_TOP_LINE.getValue(), size);
        printTableNumbers(tables);
        printLine(TABLE_BOTTOM_LINE.getValue(), size);
        System.out.print(System.lineSeparator());
    }

    public static void printMenus(final List<Menu> menus) {
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
            System.out.printf(TABLE_FORMAT.getValue(), table);
        }
        System.out.println();
    }
}
