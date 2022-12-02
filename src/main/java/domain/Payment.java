package domain;

import java.util.List;

public class Payment {
    private final List<Order> tableOrder;
    private final PaymentMethod method;
    private double totalPayment;

    private final int CHICKEN_DISCOUNT_QUANTITY = 10;
    private final int QUANTITY_DISCOUNT_AMOUNT = 10_000;
    private final double CASH_DISCOUNT_RATE = 0.05;

    public Payment(final List<Order> tableOrder, PaymentMethod method) {
        this.tableOrder = tableOrder;
        this.method = method;
        computeTotalPrice();
        discountByChickenQuantity();
        discountByPaymentMethod();
    }

    private void computeTotalPrice() {
        for (Order order : tableOrder) {
            totalPayment += computePrice(order);
        }
    }

    private int computePrice(Order order) {
        final int quantity = order.getQuantity();
        if (quantity > 0) {
            return order.getMenuPrice() * quantity;
        }
        return 0;
    }

    private void discountByChickenQuantity() {
        final int totalChickenQuantity = countChickenOrder();
        final int discountChickenQuantity
                = totalChickenQuantity / CHICKEN_DISCOUNT_QUANTITY;
        totalPayment -= discountChickenQuantity * QUANTITY_DISCOUNT_AMOUNT;
    }

    private int countChickenOrder() {
        int chickenCount = 0;
        for (Order order : tableOrder) {
            Category category = order.getMenuCategory();
            if (Category.isChicken(category)) {
                chickenCount++;
            }
        }
        return chickenCount;
    }

    private void discountByPaymentMethod() {
        if (PaymentMethod.isCash(method)) {
            final double cashDiscountAmount = totalPayment * CASH_DISCOUNT_RATE;
            totalPayment -= cashDiscountAmount;
        }
    }

    public double getTotalPayment() {
        return totalPayment;
    }
}
