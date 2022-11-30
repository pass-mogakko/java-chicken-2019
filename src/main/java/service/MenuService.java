package service;

import domain.Menu;
import domain.MenuRepository;

import java.util.List;

public class MenuService {

    public List<Menu> getAllMenus() {
        List<Menu> menus = MenuRepository.menus();
        DataValidator.validateNullOrEmpty(menus);
        return MenuRepository.menus();
    }
}
