package enums;

public enum Colors {
    WHITE,
    BLACK;


    public static Colors fromValue(Double value) {
        if (value != null && value == 1.0) {
            return WHITE;
        } else {
            return BLACK;
        }
    }
}
