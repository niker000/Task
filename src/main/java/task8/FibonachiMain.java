package task8;

import utils.PrintHelper;

public class FibonachiMain {
    public static void main(String[] args) {
        FibonachiNumbers fibonachiNumbers = new FibonachiNumbers();
        long start = Integer.parseInt(args[0]);
        long end = Integer.parseInt(args[1]);
        try {

            PrintHelper.print(fibonachiNumbers.printNumbers(fibonachiNumbers.getFibonachiNumbers(start, end)));
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            PrintHelper.print("Not not enough parameters");
        }

    }
}
