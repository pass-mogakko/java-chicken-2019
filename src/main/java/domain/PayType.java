package domain;

public enum PayType {

    CARD(0),
    CASH(0.05);

    private final double discountRate;

    PayType(double discountRate) {
        this.discountRate = discountRate;
    }

    private double getDiscountRate() {
        return discountRate;
    }

    public static int calculatePayment(PayType payType, int totalPrice) {
        return (int) (totalPrice*(1.0 - payType.getDiscountRate()));
    }
}
