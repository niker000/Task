package task4;

import run.Instructions;
import utils.FileWorker;
import utils.PrintHelper;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileParser implements Instructions {
    private static final String FILE_PARSER_INSTRUCTION = "1. Choose the program mode: \n" +
            "   1.1 Enter \"1\" if you want to get the number of occurrences of the string \n" +
            "       or \"2\" if you want to replace the line with another.\n";

    private String fileDir;
    private String text;

    public static String getFileParserInstruction() {
        return FILE_PARSER_INSTRUCTION;
    }

    public String getText() {
        return text;
    }

    public FileParser(String fileDir) {
        this.fileDir = fileDir;
        try {
            this.text = FileWorker.readFile(fileDir);
        } catch (IOException ioe) {
            PrintHelper.print("The object can not be created");
        }
    }

    public int calculateNumberOfOccurrencec(String subString) {
        String fileString = this.text;
        try {
            fileString = FileWorker.readFile(fileDir);
        } catch (FileNotFoundException ioe) {
            PrintHelper.print("No such file or directory");
        } catch (IOException ioe) {
            PrintHelper.print("Something wrong");
        }

        int fileStringLength = fileString.length();

        fileString = fileString.replaceAll(subString, "");

        return (fileStringLength - fileString.length()) / subString.length();
    }

    public void replaceWithSubString(String replaceableString, String stringToReplace) {
        if (replaceableString.length() == stringToReplace.length()) {
            indexReplacement(replaceableString, stringToReplace);
        } else {
            stringReplacement(replaceableString, stringToReplace);
        }
    }

    private int[] seekOccurenceIndex(String replaceableString) {
        int[] indexes = new int[calculateNumberOfOccurrencec(replaceableString)];
        int index = 0;
        for (int i = 0; i < indexes.length; i++) {
            index = text.indexOf(replaceableString, index + 1);
            indexes[i] = index;
        }

        return indexes;
    }

    private void indexReplacement(String replaceableString, String stringToReplace) {
        if (calculateNumberOfOccurrencec(replaceableString) == 0) {
            PrintHelper.print("There no such string in the file");
        } else {
            int[] indexes = seekOccurenceIndex(replaceableString);
            try {
                FileWorker.writeToFileByIndex(fileDir, stringToReplace.getBytes(), indexes);
            } catch (IOException ioe) {
                PrintHelper.print("Something wrong");
            }

        }
    }

    private void stringReplacement(String replaceableString, String stringToReplace) {
        String text = this.text;
        if (calculateNumberOfOccurrencec(replaceableString) == 0) {
            PrintHelper.print("There no such string in the file");
        } else {
            text = text.replaceAll(replaceableString, stringToReplace);
            try {
                FileWorker.writeToFile(fileDir, text.getBytes());
            } catch (IOException ioe) {
                PrintHelper.print("Something wrong");
            }
        }
    }
}
