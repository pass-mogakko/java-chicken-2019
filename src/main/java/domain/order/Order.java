package domain.order;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<OrderedMenu> orderedMenus = new ArrayList<>();

    public Order(OrderedMenu orderedMenu) {
        addOrderedMenu(orderedMenu);
    }

    public void addOrderedMenu(OrderedMenu adding) {
        int menuNumber = adding.getNumber();
        OrderedMenu existing = findMenuByNumber(menuNumber);
        if (existing == null) {
            orderedMenus.add(adding);
            return;
        }
        existing.increaseAmount(adding.getAmount());
    }

    public int findOrderedAmountByMenu(int menuNumber) {
        OrderedMenu orderedMenu = findMenuByNumber(menuNumber);
        if (orderedMenu == null) {
            throw new IllegalArgumentException("해당 번호를 가진 메뉴가 존재하지 않습니다.");
        }
        return orderedMenu.getAmount();
    }

    private OrderedMenu findMenuByNumber(int menuNumber) {
        return orderedMenus.stream()
                .filter(menu -> menu.getNumber() == menuNumber)
                .findFirst()
                .orElse(null);
    }
}
