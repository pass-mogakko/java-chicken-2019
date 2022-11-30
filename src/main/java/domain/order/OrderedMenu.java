package domain.order;

public class OrderedMenu {

    private final int number;
    private int amount;

    public OrderedMenu(int number, int amount) {
        this.number = number;
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public int getAmount() {
        return amount;
    }

    public void increaseAmount(int amount) {
        this.amount += amount;
    }
}
