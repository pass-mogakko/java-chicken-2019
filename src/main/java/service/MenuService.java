package service;

import domain.Menu;
import domain.MenuRepository;

import java.util.List;

public class MenuService {

    public static List<Menu> getAllMenus() {
        return MenuRepository.menus();
    }

    public static Menu getMenuByNumber(int number) {
        return MenuRepository.findMenu(menu -> menu.getNumber() == number);
    }
}
