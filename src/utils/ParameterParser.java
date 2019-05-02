package utils;

public class ParameterParser {
    public static int parseStrToInt(String parameter) throws NumberFormatException {
        return Integer.parseInt(parameter);
    }

    public static double parseStrToDouble(String parameter) {
        return Double.parseDouble(parameter);
    }
}
