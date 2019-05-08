package run;

import utils.PrintHelper;

public interface Instructions {

    static void printInstruction(String instruction) {
        PrintHelper.print(instruction);
    }


    public static final String ENVELOPE_COMPARE_INSTRUCTION = "1. Enter high and width of the chessboard \n" +
            "2. Enter high and width of the second envelope";
    public static final String TRIANGLE_LIST_INSTRUCTION = "Enter the name of the triangle and the three sides separated by commas. \n" +
            "2. If you want to continue - enter \"yes\\y\".f you enter \"no\\n\", the program will display a list of all triangles sorted by area.";



}
