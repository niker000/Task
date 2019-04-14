import Task1.ChessBoard;
import Task1.ParameterValidator;
import Task1.PrintHelper;
import Task_2.Enveloper;
import Task_2.EnveloperCompare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {
    public static void enveloperRun() throws IOException {
        double firstHeight;
        double firstWidth;
        double secondHeight;
        double secondWidth;

        boolean answer = true;


        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                PrintHelper.print("Enter height of the first enveloper");
                firstHeight = ParameterValidator.parseStrToDouble(br.readLine());

                PrintHelper.print("Enter width of the first enveloper");
                firstWidth = ParameterValidator.parseStrToDouble(br.readLine());

                PrintHelper.print("Enter height of the second enveloper");
                secondHeight = ParameterValidator.parseStrToDouble(br.readLine());

                PrintHelper.print("Enter width of the second enveloper");
                secondWidth = ParameterValidator.parseStrToDouble(br.readLine());

                Enveloper enveloper_1 = new Enveloper(firstHeight, firstWidth);
                Enveloper enveloper_2 = new Enveloper(secondHeight, secondWidth);

                if (EnveloperCompare.compare(enveloper_1, enveloper_2)) {
                    PrintHelper.print("One envelope can be inserted into another");
                }

                PrintHelper.print("Do you want to continue? y/n");

                if (br.readLine().equalsIgnoreCase("n")) {
                    answer = false;
                }
            } while (answer);

        } catch (NumberFormatException nfe) {
            PrintHelper.print("Invalid parameter");
        } catch (Exception e) {
            PrintHelper.printConsoleEnvelopInstruction();

        }
    }

    public static void chessBoardRun() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            PrintHelper.print("Enter the chessBoards height");
            int height = ParameterValidator.parseFromStrToInt(bufferedReader.readLine());

            PrintHelper.print("Enter the chessBoards width");
            int width = ParameterValidator.parseFromStrToInt(bufferedReader.readLine());

            ChessBoard chessBoard = new ChessBoard(height, width);

            PrintHelper.printConsoleBoard(chessBoard.makeBoard());
        } catch (NumberFormatException nfe) {
            PrintHelper.print("Invalid parameter");
        } catch (Exception e) {
            PrintHelper.printConsoleChessInstruction();
        }
    }
}
