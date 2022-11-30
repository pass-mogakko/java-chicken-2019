package domain.dto;

public class OrderDto {
    private String menuName;
    private String count;
    private String price;

    public OrderDto(String menuName, String count, String price) {
        this.menuName = menuName;
        this.count = count;
        this.price = price;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getCount() {
        return count;
    }

    public String getPrice() {
        return price;
    }

    public static class Builder {
        private String menuName;
        private String count;
        private String price;

        public Builder menuName(String menuName) {
            this.menuName = menuName;
            return this;
        }

        public Builder count(int count) {
            this.count = String.valueOf(count);
            return this;
        }

        public Builder price(int price) {
            this.price = String.valueOf(price);
            return this;
        }

        public OrderDto build() {
            if(menuName == null || count == null || price == null) {
                throw new IllegalArgumentException();
            }
            return new OrderDto(menuName, count, price);
        }
    }

    @Override
    public String toString() {
        return menuName + " " + count + " " + price;
    }
}
