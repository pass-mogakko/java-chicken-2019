package controller;

import domain.Menu;
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
        return new PayTypeDTO(PayType.CASH);
    }

    public static List<OrderedMenuDTO> convert(OrderedMenus menus) {
        Map<Menu, Integer> quantityByMenus = menus.getQuantityByMenus();
        return quantityByMenus.keySet()
                .stream()
                .map(menu -> createOrderedMenuDTO(menu, quantityByMenus.get(menu)))
                .collect(Collectors.toList());
    }

    private static OrderedMenuDTO createOrderedMenuDTO(Menu menu, int quantity) {
        return new OrderedMenuDTO(menu.getName(), quantity, (menu.getPrice())*quantity);
    }

    public static List<TableDTO> convert(List<Table> tables) {
        return tables.stream()
                .map(table -> new TableDTO(table.getNumber(), table.hasOrder()))
                .collect(Collectors.toList());
    }
}
