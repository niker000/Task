package Uttils;

public class ParameterValidator {
    public static int parseStrToInt(String parameter) {
        if (parameter.equals("")) {
            return -1;
        }
        int param = Integer.parseInt(parameter);

        return param;
    }

    public static double parseStrToDouble(String parameter) {
        if (parameter.equals("")) {
            return -1;
        }
        double param = Double.parseDouble(parameter);

        return param;
    }
}
