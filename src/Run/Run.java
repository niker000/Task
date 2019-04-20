package Run;

import Task1.ChessBoard;
import Task_2.Envelope;
import Task_2.EnvelopeComparator;
import Task_3.PrintTriangles;
import Task_3.Triangle;
import Task_3.TriangleCreator;
import Utils.ParameterValidator;
import Utils.PrintHelper;
import Task_3.TriangleComparator;
import Utils.UserHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Run {
    public static void envelopeRun() throws IOException {
        final int DEFAULT_NUMBER_OF_ENVELOPES = 2;

        ArrayList<Envelope> envelopeList = new ArrayList<>();

        try {
            do {
                for (int i = 0; i < DEFAULT_NUMBER_OF_ENVELOPES; i++) {
                    PrintHelper.print("Enter parameters of the enveloper");
                    envelopeList.add(new Envelope(ParameterValidator.parseStrToDouble(UserHelper.inputData()),
                            ParameterValidator.parseStrToDouble(UserHelper.inputData())));
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

    public static void triangleRun() {
        TriangleComparator triangleComparator = new TriangleComparator();
        ArrayList<Triangle> triangles = new ArrayList<>();
        try {
            do {
                PrintHelper.print("Enter the parameters of the triangle");
                triangles.add(TriangleCreator.getTriangleFromParameters(UserHelper.inputData()));
                PrintHelper.print("Do you want to continue?");

            } while (UserHelper.isContinue());
        } catch (NumberFormatException nfe) {
            PrintHelper.print("Invalid parameter");
        } catch (IOException ioe) {
            PrintHelper.print("something went wrong while entering numbers");
        } catch (IllegalArgumentException iae) {
            PrintHelper.print(iae.getMessage());
        }
        triangles.sort(triangleComparator);
        PrintTriangles.printTriangles(triangles);
    }

}
