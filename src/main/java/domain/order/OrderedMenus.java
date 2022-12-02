package domain.order;

import domain.Menu;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class OrderedMenus {

    private final Map<Menu, Integer> quantityByMenus = new LinkedHashMap<>();

    public Map<Menu, Integer> getQuantityByMenus() {
        return Collections.unmodifiableMap(quantityByMenus);
    }

    public void add(Menu menu, int quantity) {
        int totalQuantity = quantityByMenus.getOrDefault(menu, 0) + quantity;
        System.out.println(totalQuantity);
        validateQuantity(totalQuantity);
        quantityByMenus.put(menu, totalQuantity);
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
                .map(menu -> getTotalPriceByMenu(menu, quantityByMenus.get(menu)))
                .reduce(0, Integer::sum);
    }

    private int getTotalPriceByMenu(Menu menu, int quantity) {
        return (menu.getPrice())*quantity;
    }

    private int getTotalQuantity() {
        return quantityByMenus.values()
                .stream().reduce(0, Integer::sum);
    }

    private void validateQuantity(int quantity) {
        if (quantity > 99) {
            throw new IllegalArgumentException("한 메뉴에 99개 이상 주문할 수 없습니다.");
        }
    }
}
