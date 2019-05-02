package task8;

import utils.ParameterParser;
import utils.PrintHelper;

public class FibonachiMain {
    public static void main(String[] args) {
        FibonachiNumbers fibonachiNumbers = new FibonachiNumbers();
        try {
            PrintHelper.print(fibonachiNumbers.printNumbers(fibonachiNumbers.getFibonachiNumbers(ParameterParser.parseStrToInt(args[0]),
                    ParameterParser.parseStrToInt(args[1]))));
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            PrintHelper.print("Not not enough parameters");
        }

    }
}
