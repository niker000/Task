package Task_3;

import Utils.ParameterValidator;

public class TriangleCreator {
    public static Triangle getTreangleFromParameters(String inputParameter) {
        String[] parameters = inputParameter.split(",");
        for (String str : parameters) {
            str.trim();
        }

        return new Triangle(parameters[0], ParameterValidator.parseStrToDouble(parameters[1]),
                ParameterValidator.parseStrToDouble(parameters[2]),
                ParameterValidator.parseStrToDouble(parameters[3]));
    }
}
