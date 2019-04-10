package Task1;


import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        ChessBoard chessBoard = new ChessBoard(args[0], args[1]);
        PrintInfo printInfo = new PrintInfo();
        printInfo.printConsoleBoard(chessBoard.makeBoard());
    }
}
