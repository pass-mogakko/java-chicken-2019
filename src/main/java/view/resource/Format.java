package view.resource;

public enum Format {
    MAIN_SERVICE("%d - %s" + System.lineSeparator()),
    TABLE_TOP_LINE("┌ ─ ┐"),
    TABLE_FORMAT("| %s |"),
    TABLE_BOTTOM_LINE("└ ─ ┘"),
    ;

    private final String value;

    Format(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
