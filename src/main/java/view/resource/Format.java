package view.resource;

public enum Format {

    MAIN_SERVICE("%d - %s" + System.lineSeparator())
    ;

    private final String value;

    Format(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
