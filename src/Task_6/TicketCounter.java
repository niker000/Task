package Task_6;

import Utils.FileWorker;
import Utils.PrintHelper;
import Utils.UserHelper;

import java.io.IOException;

public class TicketCounter {
    public static void main(String[] args) {
        TicketCounter ticket = new TicketCounter();
        try {
            ticket.countLuckyTiket(ticket.selectAlgorithm());
        } catch (NoParameterException npe) {
            PrintHelper.print(npe.getMessage());
        }
    }

    public int countLuckyTiket(String algorithm) {
        int ticketsNumber = 0;
        int[] numbers = new int[6];
        for (int i = 1; i < 1000000; i++) {
            numbers[0] = i / 100000 % 10;
            numbers[1] = i / 10000 % 10;
            numbers[2] = i / 1000 % 10;
            numbers[3] = i / 100 % 10;
            numbers[4] = i / 10 % 10;
            numbers[5] = i % 10;

            if (algorithm.equalsIgnoreCase("moskow")) {
                if (isMoskowLucky(numbers)) {
                    ticketsNumber++;
                }
            } else if (algorithm.equalsIgnoreCase("piter")) {
                if (isPiterLucky(numbers)) {
                    ticketsNumber++;
                }
            }
        }
        System.out.println(ticketsNumber);
        return ticketsNumber;
    }

    private String selectAlgorithm() throws NoParameterException {
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

    private boolean isMoskowLucky(int[] numbers) {
        return (numbers[0] + numbers[1] + numbers[2]) == (numbers[3] + numbers[4] + numbers[5]);
    }

    private boolean isPiterLucky(int[] numbers) {
        int evenSum = 0;
        int oddNumber = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenSum += number;
            } else {
                oddNumber += number;
            }
        }
        return evenSum == oddNumber;
    }
}
