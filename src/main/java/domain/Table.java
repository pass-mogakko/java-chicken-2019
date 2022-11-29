package domain;

public class Table {
    private final int number;

    public Table(final int number) {
        this.number = number;
    }

    public boolean isPresentNumber(int tableNumber) {
        if (this.number == tableNumber) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
