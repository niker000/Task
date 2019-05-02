package utils;

import java.io.*;

public class FileWorker {

    private FileWorker() {
    }

    public static String readFile(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))) {
            int text;
            while ((text = bufferedInputStream.read()) != -1) {
                stringBuilder.append((char) text);
            }
        }
        return stringBuilder.toString();
    }

    public static void writeToFileByIndex(String fileName, byte[] stringToReplace, int[] indexes) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
            for (int index : indexes) {
                randomAccessFile.seek(index);
                randomAccessFile.write(stringToReplace);
            }
        } catch (FileNotFoundException fileNotFound) {
            PrintHelper.print("No such file or directory");
        }
    }

    public static void writeToFileFromIndex(String fileName, byte[] stringToReplace, int index) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
            randomAccessFile.seek(index);
            randomAccessFile.write(stringToReplace);
        } catch (FileNotFoundException fileNotFound) {
            PrintHelper.print("No such file or directory");
        }
    }
}


