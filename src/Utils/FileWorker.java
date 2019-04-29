package Utils;

import java.io.*;

public class FileWorker {

    private FileWorker() {
    }

    public static String readFile(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))) {
            int text;
            while ((text = bufferedInputStream.read()) != -1) {
                stringBuilder.append((char)text);
            }
        }
        return stringBuilder.toString();
    }

    public static void writeFile(String fileName, byte[] substring, int position, int endOffset) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
            randomAccessFile.seek(position);
            randomAccessFile.write(substring, position, endOffset);
        } catch (FileNotFoundException fileNotFound) {
            PrintHelper.print("No such file or directory");
        }
    }
}


