package domain.order;

import domain.MenuRepository;

import java.util.LinkedHashMap;
import java.util.Map;

public class Menus {

    private final Map<Integer, Integer> menus = new LinkedHashMap<>();

    public void add(int menuNumber, int quantity) {
        int totalQuantity = menus.getOrDefault(menuNumber, 0) + quantity;
        validateMenuNumber(menuNumber);
        validateQuantity(totalQuantity);
        menus.put(menuNumber, totalQuantity);
    }

    public void clear() {
        menus.clear();
    }

    private void validateMenuNumber(int menuNumber) {
        // TODO Repository로 접근하는 것 맞을지?
        if (!MenuRepository.hasMenu(menuNumber)) {
            throw new IllegalArgumentException("존재하지 않는 메뉴 번호입니다.");
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity > 99) {
            throw new IllegalArgumentException("한 메뉴에 99개 이상 주문할 수 없습니다.");
        }
    }
}
