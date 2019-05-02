package task6;

import Exceptions.NoParameterException;
import utils.FileWorker;
import utils.PrintHelper;
import utils.UserHelper;

import java.io.IOException;

public class TicketMain {
    public static void main(String[] args) {
        TicketCounter ticket = new TicketCounter();
        try {
            ticket.countLuckyTiket(selectAlgorithm());
        } catch (NoParameterException npe) {
            PrintHelper.print(npe.getMessage());
        }
    }

    private static String selectAlgorithm() throws NoParameterException {
        PrintHelper.print("Enter the file path:");
        String algorithm = "";
        try {
            algorithm = FileWorker.readFile(UserHelper.enterData());

        } catch (IOException ioe) {
            PrintHelper.print("Something wrong");
        }
        algorithm = algorithm.toLowerCase();
        if (algorithm.contains("moskow") | algorithm.contains("piter")) {
            if ((algorithm.indexOf("moskow") <= algorithm.indexOf("piter"))
                    && (algorithm.indexOf("piter") != -1) && algorithm.indexOf("moskow") != -1) {
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
