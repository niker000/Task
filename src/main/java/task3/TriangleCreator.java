package task3;

import utils.ParameterParser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleCreator {
    public static Triangle getTriangleFromParameters(String inputParameter) {
        List<String> param = Arrays.stream(inputParameter.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        List<Double> parameters = param.stream()
                .skip(1)
                .map(ParameterParser::parseStrToDouble)
                .peek(params -> {
                    if (params < 0) {
                        params *= -1;
                    }
                })
                .collect(Collectors.toList());

        String name = param.get(0);
        double sideA = parameters.get(0);
        double sideB = parameters.get(1);
        double sideC = parameters.get(2);

        if (!(sideA + sideB > sideC) || !(sideB + sideC > sideA) || !(sideA + sideC > sideB)) {
            throw new IllegalArgumentException("Triangle does not exist");
        }

        return new Triangle(name, sideA, sideB, sideC);
    }
}
