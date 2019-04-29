import Run.Run;
import Utils.PrintHelper;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        PrintHelper.print("Which task do you want to run: 1 - ChessBoard builder; \n" +
                "2 - Envelope comparison; \n" +
                "3 - Triangle list");

        try (Scanner sc = new Scanner(System.in)){
            while (true) {
                switch (sc.nextInt()) {
                    case (1) :
                        Run.chessBoardRun();
                        break;
                    case (2) :
                        Run.envelopeRun();
                        break;
                    case (3) :
                        Run.triangleRun();
                        break;
                    default : PrintHelper.print("Enter the correct number");
                    continue;
                }

                break;
            }
        } catch (NumberFormatException nfe) {
            PrintHelper.print("Enter number of the task");
        }
    }
}
