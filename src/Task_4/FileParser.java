package Task_4;

import Utils.FileWorker;
import Utils.PrintHelper;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileParser {
    private String fileDir;

    public FileParser(String fileDir) {
        this.fileDir = fileDir;
    }

    public int calculateNumberOfOccurrencec(String subString) {
        String fileString = "";
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

    public void replaceWithSubString(String replaceableString, String stringToReplace) throws IOException {
        String text = FileWorker.readFile(fileDir);

        if (replaceableString.length() == stringToReplace.length()) {
            indexReplacement(text, replaceableString, stringToReplace);
        } else {
            stringReplacement(text, replaceableString, stringToReplace);
        }
    }

    private int[] seekOccurenceIndex(String replaceableString) {
        int[] indexes = new int[calculateNumberOfOccurrencec(replaceableString)];
        int index = 0;
        try {
            for (int i = 0; i < indexes.length; i++) {
                indexes[i] = FileWorker.readFile(fileDir).indexOf(replaceableString, index);
                index = indexes[i] + 1;
            }
        } catch (IOException ioe) {
            PrintHelper.print("Something wrong");
        }
        return indexes;
    }

    private void indexReplacement(String text, String replaceableString, String stringToReplace) {
        if (calculateNumberOfOccurrencec(replaceableString) == 0) {
            PrintHelper.print("There no such string in the file");
        } else {
            int[] indexes = seekOccurenceIndex(replaceableString);
            StringBuilder stringBuilder = new StringBuilder(text);

            for (int index : indexes) {
                int startIndex = index;
                int endIndex;
                if ((index + stringToReplace.length()) > stringBuilder.length()) {
                    endIndex = stringBuilder.length();
                } else {
                    endIndex = index + stringToReplace.length();
                }
                stringBuilder.replace(startIndex, endIndex, stringToReplace);

                try {
                    FileWorker.writeFile(fileDir, stringBuilder.toString().getBytes(), index, replaceableString.length());
                } catch (IOException ioe) {
                    PrintHelper.print("Something wrong");
                }
            }

        }
    }

    private void stringReplacement(String text, String replaceableString, String stringToReplace) {
        int[] indexes = seekOccurenceIndex(replaceableString);
        text = text.replaceAll(replaceableString, stringToReplace);
        try {
            StringBuilder stringBuilder = new StringBuilder(text);
            stringBuilder.delete(0, indexes[0]);
            FileWorker.writeFile(fileDir, stringBuilder.toString().getBytes(), 0, stringBuilder.length());
        } catch (IOException ioe) {
            PrintHelper.print("Something wrong");
        }
    }
}
