package Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int height = 0;
        int width = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Please, enter the \"height\":");

            height = Integer.parseInt(bufferedReader.readLine());

            System.out.println("Please, enter the \"width\":");

            width = Integer.parseInt(bufferedReader.readLine());

        } catch (NumberFormatException e) {
            System.out.println("The parameter is not correct");
        }

        ChessBoard chessBoard = new ChessBoard();
        System.out.println(chessBoard.makeBoard(height, width));

    }
}
