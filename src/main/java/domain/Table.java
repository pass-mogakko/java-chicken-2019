package domain;

public class Table {

    private final int number;
    private int payingMoney = 0;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isSameNumber(int number) {
        return this.number == number;
    }

    public void menuOrder(int price) {
        payingMoney += price;
    }
}
