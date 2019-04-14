package Run;

import Task1.ChessBoard;
import Task1.ParameterValidator;
import Task1.PrintHelper;
import Task_2.Envelope;
import Task_2.EnvelopeComparator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Run {
    public static void envelopeRun() {
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

                Envelope envelope_1 = new Envelope(firstHeight, firstWidth);
                Envelope envelope_2 = new Envelope(secondHeight, secondWidth);

                if (EnvelopeComparator.compare(envelope_1, envelope_2) || EnvelopeComparator.compare(envelope_2, envelope_1) ) {
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

    public static void chessBoardRun()  {
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
