package Task1;

public class PrintHelper {
    public static void printConsoleBoard(String chessBoard) {
        print(chessBoard);
    }

    public static void printConsoleInstruction() {
        print("1. Enter the height value (the value should be natural and integer).\n" +
                "2. Enter the width value (the value should be natural and integer).");
    }

    public static void print(String str) {
        System.out.println(str);
    }
}
