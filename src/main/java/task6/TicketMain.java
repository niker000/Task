package task6;

import Exceptions.NoParameterException;
import utils.FileWorker;
import utils.PrintHelper;

import java.io.IOException;

public class TicketMain {
    public static void main(String[] args) {
        if (args.length == 0) {
            PrintHelper.print(TicketCounter.getLuckyTicketCounterInstruction());
        } else {
            TicketCounter ticket = new TicketCounter();
            try {
                ticket.countLuckyTiket(selectAlgorithm(args));
            } catch (NoParameterException npe) {
                PrintHelper.print(npe.getMessage());
            }
        }

    }

    private static String selectAlgorithm(String[] args) throws NoParameterException {
        String algorithm = "";
        try {
            algorithm = FileWorker.readFile(args[0]);
        } catch (IOException ioe) {
            PrintHelper.print("Can not read the file");
        }

        algorithm = algorithm.toLowerCase();
        if (algorithm.contains("moskow") | algorithm.contains("piter")) {
            if ((algorithm.indexOf("moskow") <= algorithm.indexOf("piter")) || algorithm.indexOf("piter") == -1) {
                algorithm = "moskow";
            } else {
                algorithm = "piter";
            }
        } else {
            throw new NoParameterException("No parameters.");
        }

        return algorithm;
    }
}
