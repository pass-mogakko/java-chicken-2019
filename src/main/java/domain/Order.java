package domain;

public class Order {
    private final Menu menu;
    private final int quantity;

    public Order(final Menu menu, final int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getMenuName() {
        return menu.getName();
    }

    public int getAmount() {
        return menu.getPrice() * quantity;
    }

    public Category getMenuCategory() {
        return menu.getCategory();
    }

    @Override
    public String toString() {
        return menu + " " + quantity;
    }
}
