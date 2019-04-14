package Task_2;

public class EnvelopeComparator {
    public static boolean compare(Envelope enveloper1, Envelope enveloper2) {
        if (((enveloper1.getWidth() > enveloper2.getWidth()))
                && (enveloper1.getHeight() > enveloper2.getHeight())) {
            return true;
        } else if(((enveloper1.getHeight() > enveloper2.getWidth()))
                && ((enveloper1.getWidth() > enveloper2.getHeight()))) {
            return true;
        } else {
            return false;
        }
    }
}
