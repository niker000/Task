package Task_4;

public class Task4Main {
    public static void main(String[] args) throws Exception {
        FileParser fileParser = new FileParser("C:\\Users\\niker000\\Desktop\\java.txt");

        System.out.println(fileParser.calculateNumberOfOccurrencec("mama"));

        fileParser.replaceWithSubString("mama", "papa");
    }
}
