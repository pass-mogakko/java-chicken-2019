package domain.payment;

public enum Method {
    CARD(1, "카드", 1),
    CASH(2, "현금", 0.95);

    private final int command;
    private final String name;
    private final double discountRate;

    Method(int command, String name, double discountRate) {
        this.command = command;
        this.name = name;
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
