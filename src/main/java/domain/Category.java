package domain;

public enum Category {
    CHICKEN("치킨"),
    BEVERAGE("음료");

    private final String name;

    Category(final String name) {
        this.name = name;
    }

    public static boolean isChicken(final Category category) {
        return category == CHICKEN;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
