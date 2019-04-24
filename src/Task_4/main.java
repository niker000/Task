package Task_4;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        FileParser fileParser = new FileParser("C:\\Users\\niker000\\Desktop\\java.txt");
        System.out.println(fileParser.calculateNumberOfOccurrencec("abc"));

    }
}
