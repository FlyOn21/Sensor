package enums;

public enum Colors {
    WHITE,
    BLACK;

    public static Colors fromValue(Double value) {
        if (value != null && value == 0.0) {
            return WHITE;
        } else {
            return BLACK;
        }
    }
}
