package task6;

public class TicketCounter {
    private static final String LUCKY_TICKET_COUNTER_INSTRUCTION = "Program will count how many tickets can be lucky. \n" +
            "To choose the method of calculation, enter Piter or Moscow in the file and specify the path to the file in the program settings";

    public static String getLuckyTicketCounterInstruction() {
        return LUCKY_TICKET_COUNTER_INSTRUCTION;
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
