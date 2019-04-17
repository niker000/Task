package Run;

import Task1.ChessBoard;
import Task_2.Envelope;
import Task_2.EnvelopeComparator;
import Uttils.ParameterValidator;
import Uttils.PrintHelper;
import Uttils.UserHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Run {
    public static void envelopeRun() throws IOException {
        double height;
        double width;
        final int DEFAULT_NUMBER_OF_ENVELOPES = 2;

        ArrayList<Envelope> envelopeList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                for (int i = 0; i < DEFAULT_NUMBER_OF_ENVELOPES; i++) {
                    PrintHelper.print("Enter height of the enveloper");
                    height = ParameterValidator.parseStrToDouble(br.readLine());

                    PrintHelper.print("Enter width of the enveloper");
                    width = ParameterValidator.parseStrToDouble(br.readLine());

                    if (height == -1 && width == -1) {
                        PrintHelper.printConsoleEnvelopInstruction();
                        break;
                    }
                    envelopeList.add(new Envelope(height, width));
                }

                if (EnvelopeComparator.compare(envelopeList.get(0), envelopeList.get(1))
                        || EnvelopeComparator.compare(envelopeList.get(1), envelopeList.get(0))) {

                    PrintHelper.print("One envelope can be inserted into another");
                } else {
                    PrintHelper.print("One envelope cannot be inserted into another");
                }

                PrintHelper.print("Do you want to continue? y/n");

            } while (UserHelper.isContinue());

        } catch (NumberFormatException nfe) {
            PrintHelper.print("Invalid parameter");
        }
    }

    public static void chessBoardRun() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                PrintHelper.print("Enter the chessBoards height");
                int height = ParameterValidator.parseStrToInt(bufferedReader.readLine());

                PrintHelper.print("Enter the chessBoards width");
                int width = ParameterValidator.parseStrToInt(bufferedReader.readLine());

                if (height == -1 && width == -1) {
                    PrintHelper.printConsoleEnvelopInstruction();

                }
                ChessBoard chessBoard = new ChessBoard(height, width);

                PrintHelper.printConsoleBoard(chessBoard.makeBoard());

        } catch (NumberFormatException nfe) {
            PrintHelper.print("Invalid parameter");
        }
    }
}
