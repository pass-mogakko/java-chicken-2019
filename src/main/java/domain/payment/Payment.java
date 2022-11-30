package domain.payment;

import domain.order.Order;
import domain.table.Table;

import java.util.List;

public class Payment {
    private Table table;
    private List<Order> orders;
    private Method method;
    private static int DISCOUNT_UNIT = 10;
    private static int DISCOUNT_PRICE_PER_TYPE = 10000;

    public Payment(Table table, List<Order> orders, Method Method) {
        this.table = table;
        this.orders = orders;
        this.method = Method;
    }

    public int calculateTotalPrice() {
        int sum = 0;
        for (Order order : orders) {
            sum += order.getMenu().getPrice() * order.getCount();
        }
        int discountPrice = calculateDiscountPrice();
        sum -= discountPrice;
        sum *= method.getDiscountRate();
        return sum;
    }

    private int calculateDiscountPrice() {
        int chickenCount = countChickenOrders();
        return chickenCount * DISCOUNT_PRICE_PER_TYPE / DISCOUNT_UNIT;
    }

    private int countChickenOrders() {
        int cnt = 0;
        for (Order order : orders) {
            if (order.isChickenMenu()) {
                cnt += order.getCount();
            }
        }
        return cnt;
    }
}
