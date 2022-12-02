package service;

import domain.PayType;
import domain.Table;
import dto.PayTypeDTO;

public class PayService {


    private static final PayService instance = new PayService();

    private PayService() { }

    public static PayService getInstance() {
        return instance;
    }

    public int calculateTotalPayment(int tableNumber, PayTypeDTO payTypeDTO) {
        Table table = TableService.getTableByNumber(tableNumber);
        int totalPrice = table.getTotalPrice();
        return getTotalPaymentByPayType(payTypeDTO.getPayType(),totalPrice);
    }

    public void completePayment(int tableNumber) {
        Table table = TableService.getTableByNumber(tableNumber);
        table.completeOrder();
    }

    private int getTotalPaymentByPayType(PayType payType, int totalPrice) {
        return PayType.calculatePayment(payType, totalPrice);
    }
}
