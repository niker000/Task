package task1;

import utils.ParameterParser;
import utils.PrintHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessBoardMain  {
    public static final String CHESS_BOARD_INSTRUCTION = "1. Enter high and width of the chessboard";

    public static void main(String[] args) {
        chessBoardRun();
    }

    private static void chessBoardRun() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            PrintHelper.print("Enter the chessBoards height");
            int height = ParameterParser.parseStrToInt(bufferedReader.readLine());

            PrintHelper.print("Enter the chessBoards width");
            int width = ParameterParser.parseStrToInt(bufferedReader.readLine());

            ChessBoard chessBoard = new ChessBoard(height, width);

            PrintHelper.print(chessBoard.makeBoard());
        } catch (NumberFormatException nfe) {
            PrintHelper.print("Invalid parameter");
        } catch (IOException ioe) {
            PrintHelper.print("Something wrong");
        }
    }

    public void printInstruction() {
        PrintHelper.print(CHESS_BOARD_INSTRUCTION);
    }
}
