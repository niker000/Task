package task4;

import utils.ParameterValidator;
import utils.PrintHelper;

import java.util.Scanner;

public class FileParserMain {
    public static void main(String[] args) throws Exception {
        if (!ParameterValidator.isValid(args)) {
            PrintHelper.print(FileParser.getFileParserInstruction());
        }
        FileParser fileParser = new FileParser(args[0]);
        switch (new Scanner(System.in).nextInt()) {
            case 1:
                fileParser.calculateNumberOfOccurrencec(args[1]);
                break;
            case 2:
                fileParser.replaceWithSubString(args[1], args[2]);
                break;
        }
    }
}
