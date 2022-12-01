package view;

import static view.resource.Format.ORDER_EMPTY;
import static view.resource.Format.ORDER_FORMAT;
import static view.resource.Format.ORDER_INDEX;
import static view.resource.Format.TABLE_FORMAT;
import static view.resource.Format.TABLE_TOP_LINE;

import domain.Menu;
import dto.OrderedMenuDTO;
import dto.TableDTO;
import view.resource.Format;
import view.resource.Main;

import java.util.Arrays;
import java.util.List;

// TODO 중복 코드 리팩토링, 메시지 상수화
public class OutputView {

    public static void printMain() {
        System.out.println("## 메인화면");
        Arrays.stream(Main.values())
                .forEach(service -> System.out.printf(Format.MAIN_SERVICE.getValue(),
                        service.getNumber(), service.getName()));
        System.out.print(System.lineSeparator());
    }

    public static void printTables(final List<TableDTO> tables) {
        IOValidator.validateNotNull(tables);
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printTopLine(TABLE_TOP_LINE.getValue(), size);
        printTableNumbers(tables);
        printBottomLine(tables);
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

    // TODO 원시값도 DTO로 캡슐화하기
    public static void printTotalPayment(int totalPayment) {
        System.out.println("## 최종 결제할 금액");
        System.out.printf("%d원" + System.lineSeparator(), totalPayment);
        System.out.print(System.lineSeparator());
    }

    private static void printOrderedMenu(final List<OrderedMenuDTO> orderedMenus) {
        for (final OrderedMenuDTO menu : orderedMenus) {
            System.out.printf(ORDER_FORMAT.getValue(), menu.getName(), menu.getQuantity(), menu.getTotalPrice());
            System.out.print(System.lineSeparator());
        }
    }

    private static void printTopLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printBottomLine(final List<TableDTO> tables) {
        for (final TableDTO table : tables) {
            System.out.print(Format.getRightTableBottomLine(table));
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<TableDTO> tables) {
        for (final TableDTO table : tables) {
            System.out.printf(TABLE_FORMAT.getValue(), table.getNumber());
        }
        System.out.println();
    }
}
