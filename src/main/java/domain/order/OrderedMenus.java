package domain.order;

import domain.Menu;
import domain.MenuRepository;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class OrderedMenus {

    // TODO Key Menu로 수정
    private final Map<Integer, Integer> quantityByMenus = new LinkedHashMap<>();

    public Map<Integer, Integer> getQuantityByMenus() {
        return Collections.unmodifiableMap(quantityByMenus);
    }

    public void add(int menuNumber, int quantity) {
        int totalQuantity = quantityByMenus.getOrDefault(menuNumber, 0) + quantity;
        validateMenuNumber(menuNumber);
        validateQuantity(totalQuantity);
        quantityByMenus.put(menuNumber, totalQuantity);
    }

    public void clear() {
        quantityByMenus.clear();
    }

    public int getTotalPriceWithQuantityDiscount() {
        int discountPrice = 0;
        int totalQuantity = getTotalQuantity();
        if (totalQuantity > 10) {
            discountPrice = totalQuantity*(1_000);
        }
        return addAllMenuPrice() - discountPrice;
    }

    private int addAllMenuPrice() {
        return quantityByMenus.keySet()
                .stream()
                .map(this::getMenuPrice)
                .reduce(0, Integer::sum);
    }

    private int getMenuPrice(int number) {
        Menu menu = MenuRepository.getMenuByNumber(number);
        return (menu.getPrice())*(quantityByMenus.get(number));
    }

    private int getTotalQuantity() {
        return quantityByMenus.values()
                .stream().reduce(0, Integer::sum);
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
