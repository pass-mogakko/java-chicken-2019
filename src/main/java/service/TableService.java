package service;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import dto.OrderedMenuDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TableService {

    public List<Table> getAllTables() {
        List<Table> tables = TableRepository.tables();
        return tables;
    }

    public void addTableOrder(int tableNumber, int menuNumber, int quantity) {
        Table tableForOrder = TableRepository.getTableByNumber(tableNumber);
        tableForOrder.updateOrder(menuNumber, quantity);
    }

    public List<OrderedMenuDTO> getOrderByTable(int tableNumber) {
        Table table = TableRepository.getTableByNumber(tableNumber);
        return convertOrderedMenuDTOs(table.getOrderMenus());
    }

    private List<OrderedMenuDTO> convertOrderedMenuDTOs(Map<Integer, Integer> menus) {
        return menus.keySet()
                .stream()
                .map(number -> convertOrderedMenuDTo(number, menus.get(number)))
                .collect(Collectors.toList());
    }

    private OrderedMenuDTO convertOrderedMenuDTo(int number, int quantity) {
        Menu menu = MenuRepository.getMenuByNumber(number);
        return new OrderedMenuDTO(menu.getName(), quantity, (menu.getPrice())*quantity);
    }
}
