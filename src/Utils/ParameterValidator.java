package Utils;

public class ParameterValidator {
    public static int parseStrToInt(String parameter) throws NumberFormatException {
        if (parameter.equals("")) {
            throw new NumberFormatException();
        }
        int param = Integer.parseInt(parameter);

        return param;
    }

    public static double parseStrToDouble(String parameter) {
        if (parameter.equals("")) {
            return -1;
        }
        return Double.parseDouble(parameter);
    }



}
