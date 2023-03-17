public class Formatter {
    public static String getFormattedRubles(Double cost) {
        int value = (int) Math.floor(cost);
        String stringV = String.valueOf(value);
        char lastChar = stringV.charAt(stringV.length() - 1);
        String label = "";
        if (lastChar == '0' || lastChar == '5' || lastChar == '6' || lastChar == '7' || lastChar == '8' || lastChar == '9' || stringV.equals("11") || stringV.equals("12") || stringV.equals("13") || stringV.equals("14")) {
            label = "rublei";
        } else if (lastChar == '1') {
            label = "rubl";
        } else if (lastChar == '2' || lastChar == '3' || lastChar == '4') {
            label = "rublya";
        }
        return String.format("%.2f %s", cost, label);
    }
}
