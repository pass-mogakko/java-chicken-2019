package domain.payment;

import domain.order.Order;
import domain.table.Table;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Payment {
    private Table table;
    private List<Order> orders;
    private Method method;
    private static int DISCOUNT_RATE = 10;
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
        int chickenTypes = getChickenTypes();
        return chickenTypes / DISCOUNT_RATE * DISCOUNT_PRICE_PER_TYPE;
    }

    private int getChickenTypes() {
        Set<Integer> types = new HashSet<>();
        for (Order order : orders) {
            if (order.getMenu().getNumber() > 6) {
                types.add(order.getMenu().getNumber());
            }
        }
        return types.size();
    }
}
