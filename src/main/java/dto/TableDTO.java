package dto;

public class TableDTO {

    private final int number;
    private final boolean hasOrder;

    public TableDTO(int number, boolean hasOrder) {
        this.number = number;
        this.hasOrder = hasOrder;
    }

    public int getNumber() {
        return number;
    }

    public boolean hasOrder() {
        return hasOrder;
    }
}
