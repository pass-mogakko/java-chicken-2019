package domain;

public class Payment {
    private final Table table;
    private int payment;

    public Payment(final Table table, int payment){
        this.table = table;
        this.payment = payment;
    }

    public void addPayment(final int price){
        payment += price;
    }

    public int getPayment(){
        return this.payment;
    }
}
