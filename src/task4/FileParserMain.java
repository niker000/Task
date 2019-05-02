package task4;

import java.util.Scanner;

public class FileParserMain {
    public static void main(String[] args) throws Exception {
        FileParser fileParser = new FileParser(args[0]);
        switch (new Scanner(System.in).nextInt()) {
            case 1:
                fileParser.calculateNumberOfOccurrencec(args[1]);
                break;
            case 2:
                fileParser.replaceWithSubString(args[1], args[3]);
                break;
        }
    }
}
