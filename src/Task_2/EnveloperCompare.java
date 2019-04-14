package Task_2;

public class EnveloperCompare {
    public static boolean compare(Enveloper enveloper1, Enveloper enveloper2) {
        if (((enveloper1.getWidth() - enveloper2.getWidth()) != 0) && (enveloper1.getHeight() - enveloper2.getHeight()) != 0) {
            return true;
        } else if(((enveloper1.getHeight() - enveloper2.getWidth()) != 0) && ((enveloper1.getWidth() - enveloper2.getHeight()) != 0)) {
            return true;
        } else {
            return false;
        }
    }
}
