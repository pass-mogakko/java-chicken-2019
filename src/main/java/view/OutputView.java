package view;

import static view.resource.Format.ORDER_EMPTY;
import static view.resource.Format.ORDER_FORMAT;
import static view.resource.Format.ORDER_INDEX;
import static view.resource.Format.TABLE_BOTTOM_LINE;
import static view.resource.Format.TABLE_FORMAT;
import static view.resource.Format.TABLE_TOP_LINE;

import domain.Menu;
import domain.Table;
import dto.OrderedMenuDTO;
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
        IOValidator.validateNotNull(tables);
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TABLE_TOP_LINE.getValue(), size);
        printTableNumbers(tables);
        printLine(TABLE_BOTTOM_LINE.getValue(), size);
        System.out.print(System.lineSeparator());
    }

    public static void printMenus(final List<Menu> menus) {
        IOValidator.validateNotNull(menus);
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        System.out.print(System.lineSeparator());
    }

    public static void printOrder(final List<OrderedMenuDTO> orderedMenus) {
        IOValidator.validateNotNull(orderedMenus);
        if (orderedMenus.isEmpty()) {
            System.out.println(ORDER_EMPTY.getValue());
            System.out.print(System.lineSeparator());
            return;
        }
        System.out.println(ORDER_INDEX.getValue());
        printOrderedMenu(orderedMenus);
        System.out.print(System.lineSeparator());
    }

    private static void printOrderedMenu(final List<OrderedMenuDTO> orderedMenus) {
        for (final OrderedMenuDTO menu : orderedMenus) {
            System.out.printf(ORDER_FORMAT.getValue(), menu.getName(), menu.getQuantity(), menu.getTotalPrice());
            System.out.print(System.lineSeparator());
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
