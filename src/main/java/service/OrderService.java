package service;

import domain.MenuRepository;
import domain.TableRepository;
import domain.order.OrderedMenu;
import domain.TableOrderRepository;

public class OrderService {

    public void updateTableOrder(int tableNumber, int menuNumber, int menuAmount) {
        validateTable(tableNumber);
        validateOrderedMenu(menuNumber);
        validateOrderedAmount(tableNumber, menuNumber, menuAmount);
        TableOrderRepository.updateOrderedMenus(tableNumber, new OrderedMenu(menuNumber, menuAmount));
    }

    private void validateTable(int tableNumber) {
        if (!TableRepository.hasTable(tableNumber)) {
            throw new IllegalArgumentException("존재하지 않는 테이블 번호로 주문을 받았습니다.");
        }
    }

    private void validateOrderedMenu(int menuNumber) {
        if (!MenuRepository.hasMenu(menuNumber)) {
            throw new IllegalArgumentException("존재하지 않는 메뉴 번호로 주문을 받았습니다.");
        }
    }

    private void validateOrderedAmount(int tableNumber, int menuNumber, int menuAmount) {
        int currentAmount = TableOrderRepository.getOrderedAmount(tableNumber, menuNumber);
        if (currentAmount + menuAmount > 99) {
            throw new IllegalArgumentException("한 테이블에서 주문할 수 있는 한 메뉴의 최대 수량은 99개입니다.");
        }
    }
}
