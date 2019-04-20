package Task_3;

import Utils.ParameterValidator;

public class TriangleCreator {
    public static Triangle getTriangleFromParameters(String inputParameter) {
        String[] parameters = inputParameter.split(",");
        for (String str : parameters) {
            str.trim();
        }
        double sideA = ParameterValidator.parseStrToDouble(parameters[1]);
        double sideB = ParameterValidator.parseStrToDouble(parameters[2]);
        double sideC = ParameterValidator.parseStrToDouble(parameters[3]);

        if (!(sideA + sideB > sideC) || !(sideB + sideC > sideA) || !(sideA + sideC > sideB)) {
            throw new IllegalArgumentException("Triangle dose note exist");
        }

        return new Triangle(parameters[0], sideA, sideB, sideC);

    }
}
