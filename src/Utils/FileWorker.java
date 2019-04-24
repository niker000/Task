package Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileWorker {

    private FileWorker() {
    }

    public static String readFile(String fileName) throws IOException {

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "r")) {

            return randomAccessFile.readLine();

        }
    }

    public static void writeFile(String fileName, Byte[] substring) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {

        } catch (FileNotFoundException fileNotFound) {
            PrintHelper.print("No such file or directory");
        }
    }

}


