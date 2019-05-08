package task7;

import utils.PrintHelper;

public class SequenceMain {
    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        if (parameterValidator(Integer.parseInt(args[0]))) {
            sequence.printSequence(sequence.getSequenсe(Integer.parseInt(args[0])));
        } else {
            PrintHelper.print("There is no numbers");
        }
    }

    private static boolean parameterValidator(int arg) {
        return (arg > 0);
    }
}
