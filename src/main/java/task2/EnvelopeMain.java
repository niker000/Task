package task2;

import utils.ParameterParser;
import utils.PrintHelper;
import utils.UserHelper;

import java.io.IOException;
import java.util.ArrayList;

public class EnvelopeMain {
    public static void main(String[] args) {
        try {
            envelopeRun();
        } catch (IOException ioe) {
            PrintHelper.print("Something wrong");
        }
    }

    private static void envelopeRun() throws IOException {
        final int DEFAULT_NUMBER_OF_ENVELOPES = 2;

        ArrayList<Envelope> envelopeList = new ArrayList<>();

        try {
            do {
                for (int i = 0; i < DEFAULT_NUMBER_OF_ENVELOPES; i++) {
                    PrintHelper.print("Enter parameters of the enveloper");
                    envelopeList.add(new Envelope(ParameterParser.parseStrToDouble(UserHelper.enterData()),
                            ParameterParser.parseStrToDouble(UserHelper.enterData())));
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
}
