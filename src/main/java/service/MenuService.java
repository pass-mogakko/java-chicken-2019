package service;

import domain.Menu;
import domain.MenuRepository;

import java.util.List;

public class MenuService {

    private final static MenuService instance = new MenuService();

    private MenuService() {
    }

    public static MenuService getInstance() {
        return instance;
    }

    public List<Menu> getAllMenus() {
        return MenuRepository.menus();
    }

    public Menu getMenuByNumber(int number) {
        return MenuRepository.findMenu(menu -> menu.getNumber() == number);
    }
}
