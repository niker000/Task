package task9;

import java.math.BigInteger;

public class NumberPower {
    public static BigInteger pow(int a, int n) {
        if (n == 0)
            return BigInteger.valueOf(1);
        if (n % 2 == 1)
            return pow(a, n - 1).multiply(BigInteger.valueOf(a));
        else {
            BigInteger b = pow(a, n / 2);
            return b.pow(2);
        }
    }
}
