package task7;

import utils.PrintHelper;

import java.util.ArrayList;
import java.util.List;

public class Sequence {
    public ArrayList<Integer> getSequenсe(int number) {
        ArrayList<Integer> numberSequence = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(number); i++) {
            numberSequence.add(i);
        }
        return numberSequence;
    }

    public void printSequence(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder("0");
        for (Integer num : numbers) {
            stringBuilder.append("," + num);
        }
        PrintHelper.print(stringBuilder.toString());
    }
}
