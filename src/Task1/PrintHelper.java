package Task1;

public class PrintHelper {
    public static void printConsoleBoard(String chessBoard) {
        print(chessBoard);
    }

    public static void printConsoleChessInstruction() {
        print("1. Enter the height value (the value should be natural and integer).\n" +
                "2. Enter the width value (the value should be natural and integer).");
    }

    public static void printConsoleEnvelopInstruction() {
        System.out.println("1. Enter envelope parameters" +'\n' +
                "2. Enter \" y\" if you want to continue or \"n\" to end the program");
    }

    public static void print(String str) {
        System.out.println(str);
    }
}
