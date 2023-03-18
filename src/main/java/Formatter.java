public class Formatter {
    public static String getFormattedRubles(double cost) {
        int value = (int) Math.floor(cost);
        int last = value % 100;
        int last10 = value % 10;
        String stringV = String.valueOf(value);
        char lastChar = stringV.charAt(stringV.length() - 1);
        String label = "";
        if ((last <= 14 && last >= 10)) {
            label = "rublei";
        }
        else {
            if (last10 == 0 || last10 >= 5) {
                label = "rublei";
            }
            else if (last10 == 1) {
                label = "rubl";
            } else if (lastChar >= 2 && last <= 4) {
                label = "rublya";
            }
        }
        return String.format("%.2f %s", cost, label);
    }
}
