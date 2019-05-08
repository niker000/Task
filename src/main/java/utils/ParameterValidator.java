package utils;

public class ParameterValidator {
    public static boolean isValid(String[] parameters) {
        for (String param : parameters) {
            if (param.equals(null) || param.equals("")) {
                return false;
            }
        }
        return true;
    }
}
