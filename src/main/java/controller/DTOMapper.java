package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.order.OrderedMenus;
import dto.OrderedMenuDTO;
import dto.TableDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DTOMapper {

    public static List<OrderedMenuDTO> convert(OrderedMenus menus) {
        Map<Integer, Integer> quantityByMenus = menus.getQuantityByMenus();
        return quantityByMenus.keySet()
                .stream()
                .map(number -> convertOrderedMenuDTo(number, quantityByMenus.get(number)))
                .collect(Collectors.toList());
    }

    private static OrderedMenuDTO convertOrderedMenuDTo(int number, int quantity) {
        Menu menu = MenuRepository.getMenuByNumber(number);
        return new OrderedMenuDTO(menu.getName(), quantity, (menu.getPrice())*quantity);
    }


    public static List<TableDTO> convert(List<Table> tables) {
        return tables.stream()
                .map(table -> new TableDTO(table.getNumber(), table.hasOrder()))
                .collect(Collectors.toList());
    }
}
