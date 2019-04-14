package Task_2;

public class EnvelopeComparator {
    public static boolean compare(Envelope enveloper1, Envelope enveloper2) {
        if (((enveloper1.getWidth() - enveloper2.getWidth()) > 0)
                && (enveloper1.getHeight() - enveloper2.getHeight()) > 0) {
            return true;
        } else if(((enveloper1.getHeight() - enveloper2.getWidth()) >0)
                && ((enveloper1.getWidth() - enveloper2.getHeight()) > 0)) {
            return true;
        } else {
            return false;
        }
    }
}
