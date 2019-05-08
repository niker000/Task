package task4;

import run.Instructions;
import utils.ParameterValidator;

import java.util.Scanner;

public class FileParserMain {
    public static void main(String[] args) throws Exception {
        if (!ParameterValidator.isValid(args) || args.length == 0) {
            Instructions.printInstruction(FileParser.getFileParserInstruction());
        } else {
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
}
