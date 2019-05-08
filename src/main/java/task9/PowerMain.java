package task9;

import task6.TicketCounter;
import utils.PrintHelper;

public class PowerMain {
    public static void main(String[] args) {
        if (args.length == 0) {
            PrintHelper.print(TicketCounter.getLuckyTicketCounterInstruction());
        } else {
            try {
                PrintHelper.print(NumberPower.pow(Integer.parseInt(args[0]), Integer.parseInt(args[1])).toString());
            } catch (ArrayIndexOutOfBoundsException iobe) {
                PrintHelper.print("Invalid parameters");
            } catch (NumberFormatException nfe) {
                PrintHelper.print("Parameters mast be numbers");
            }
        }
    }
}
