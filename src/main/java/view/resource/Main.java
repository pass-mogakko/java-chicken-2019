package view.resource;

public enum Main {

    ORDER(1, "주문등록"),
    PAY(2, "결제하기"),
    EXIT(3, "프로그램 종료")
    ;

    private final int number;
    private final String name;

    Main(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
