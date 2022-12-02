package service;

import domain.Menu;
import domain.MenuRepository;

import java.util.List;

public class MenuService {

    private static MenuService instance = new MenuService();

    private MenuService() {
    }

    public static MenuService getInstance() {
        return instance;
    }

    public List<Menu> getAllMenus() {
        return MenuRepository.menus();
    }
    // TODO Menu 조회 이 클래스 통해서 하도록 하기
}
