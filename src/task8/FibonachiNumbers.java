package task8;

import java.util.ArrayList;
import java.util.List;

public class FibonachiNumbers {

    public String printNumbers(List<Long> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            stringBuilder.append(", " + numbers.get(i));
        }
        return stringBuilder.toString();
    }

    public List<Long> getFibonachiNumbers(long start, long end) {
        ArrayList<Long> numbers = new ArrayList<>();
        for (int i = 0; fibBinet(i) <= end; i++) {
            long number = fibBinet(i);
            if (number >= start) {
                numbers.add(number);
                // System.out.print(number + ", ");
            }
        }
        return numbers;
    }

    public long fibBinet(long n) {
        if (n > 70) {
            return fibNumber(n);
        }

        double fi = (1 + Math.sqrt(5)) / 2;
        return Math.round(Math.pow(fi, n) / Math.sqrt(5));
    }

    public long fibNumber(long n) {
        long a = 190392490709135L; // n = 70
        long b = 117669030460994L;  //n = 69
        long x;

        for (long i = 0; i < n; i++) {
            x = a + b;
            a = b;
            b = x;
        }
        return b;
    }
}
