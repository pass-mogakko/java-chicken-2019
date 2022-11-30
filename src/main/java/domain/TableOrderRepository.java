package domain;

import domain.order.Order;
import domain.order.OrderedMenu;
import domain.order.TableOrder;

import java.util.ArrayList;
import java.util.List;

public class TableOrderRepository {

    private static final List<TableOrder> orders = new ArrayList<>();

    public static void updateOrderedMenus(int tableNumber, OrderedMenu orderedMenu) {
        TableOrder existingOrder = findPendingOrderByTable(tableNumber);
        if (existingOrder == null) {
            TableOrderRepository.insert(tableNumber, orderedMenu);
            return;
        }
        existingOrder.addOrder(orderedMenu);
    }

    public static int getOrderedAmount(int tableNumber, int menuNumber) {
        TableOrder tableOrder = findPendingOrderByTable(tableNumber);
        if (tableOrder == null) {
            return 0;
        }
        return tableOrder.getOrder()
                .findOrderedAmountByMenu(menuNumber);
    }

    private static void insert(int tableNumber, OrderedMenu orderedMenu) {
        orders.add(new TableOrder(tableNumber, new Order(orderedMenu)));
    }

    private static TableOrder findPendingOrderByTable(int tableNumber) {
        return orders.stream()
                .filter(TableOrder::isPending)
                .filter(tableOrder -> tableOrder.getTableNumber() == tableNumber)
                .findFirst()
                .orElse(null);
    }
}
