package Task_4;

import Utils.FileWorker;
import Utils.PrintHelper;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileParser {
    public String fileDir;
    private StringBuilder stringBuilder;

    public FileParser(String fileDir) {
        this.fileDir = fileDir;
    }

    public int calculateNumberOfOccurrencec(String subString) {
        String fileString = "";
        try {
            fileString = FileWorker.readFile(fileDir);
        } catch (FileNotFoundException ioe) {
            PrintHelper.print("No such file or directory");
        }catch (IOException ioe) {
            PrintHelper.print("Something wrong");
        }

        int fileStringLength = fileString.length();

        fileString = fileString.replaceAll(subString,"");

        return (fileStringLength - fileString.length())/subString.length();
    }

    public void replaceWithSubString(String subString) {

    }
}
