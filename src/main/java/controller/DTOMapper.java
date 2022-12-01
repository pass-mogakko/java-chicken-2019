package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.PayType;
import domain.Table;
import domain.order.OrderedMenus;
import dto.OrderedMenuDTO;
import dto.PayTypeDTO;
import dto.TableDTO;
import view.resource.PayTypeCommand;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DTOMapper {

    public static PayTypeDTO convert(PayTypeCommand payCommand) {
        if (payCommand == PayTypeCommand.CARD) {
            return new PayTypeDTO(PayType.CARD);
        }
        if (payCommand == PayTypeCommand.CASH) {
            return new PayTypeDTO(PayType.CASH);
        }
        // TODO 검증로직 검토
        throw new IllegalArgumentException("");
    }

    public static List<OrderedMenuDTO> convert(OrderedMenus menus) {
        Map<Integer, Integer> quantityByMenus = menus.getQuantityByMenus();
        return quantityByMenus.keySet()
                .stream()
                .map(number -> createOrderedMenuDTO(number, quantityByMenus.get(number)))
                .collect(Collectors.toList());
    }

    private static OrderedMenuDTO createOrderedMenuDTO(int number, int quantity) {
        Menu menu = MenuRepository.getMenuByNumber(number);
        return new OrderedMenuDTO(menu.getName(), quantity, (menu.getPrice())*quantity);
    }

    public static List<TableDTO> convert(List<Table> tables) {
        return tables.stream()
                .map(table -> new TableDTO(table.getNumber(), table.hasOrder()))
                .collect(Collectors.toList());
    }
}
