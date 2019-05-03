package task8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FibonachiNumbers {

    public String printNumbers(List<BigInteger> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            stringBuilder.append(", " + numbers.get(i));
        }
        return stringBuilder.toString();
    }

    public List<BigInteger> getFibonachiNumbers(long start, long end) {

        ArrayList<BigInteger> numbers = new ArrayList<>();
        for (int i = 0; (fibonacci(i).compareTo(BigInteger.valueOf(end))== -1); i++) {
            BigInteger number = fibonacci(i);
            if (number.compareTo(BigInteger.valueOf(start))>=0) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    public BigInteger[][] matrixMultiplication(BigInteger[][] a, BigInteger[][] b) {
        // [a00 * b00 + a01 * b10, a00 * b01 + a01 * b11]
        // [a10 * b00 + a11 * b10, a10 * b01 + a11 * b11]
        return new BigInteger[][]{
                {a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])), a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]))},
                {a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])), a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]))},
        };
    }

    // возведение матрицы размера 2 на 2 в степень n
    public BigInteger[][] matrixPowerFast(BigInteger[][] a, int n) {
        if (n == 0) {
            // любая матрица в нулевой степени равна единичной матрице
            return new BigInteger[][]{
                    {BigInteger.ONE, BigInteger.ZERO},
                    {BigInteger.ZERO, BigInteger.ONE}
            };
        } else if (n % 2 == 0) {
            // a ^ (2k) = (a ^ 2) ^ k
            return matrixPowerFast(matrixMultiplication(a, a), n / 2);
        } else {
            // a ^ (2k + 1) = (a) * (a ^ 2k)
            return matrixMultiplication(matrixPowerFast(a, n - 1), a);
        }
    }

    // функция, возвращающая n-ое число Фибоначчи
    public BigInteger fibonacci(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        }

        BigInteger[][] a = {
                {BigInteger.ONE, BigInteger.ONE},
                {BigInteger.ONE, BigInteger.ZERO}
        };
        BigInteger[][] powerOfA = matrixPowerFast(a, n - 1);
        // nthFibonacci = powerOfA[0][0] * F_1 + powerOfA[0][0] * F_0 = powerOfA[0][0] * 1 + powerOfA[0][0] * 0
        BigInteger nthFibonacci = powerOfA[0][0];
        return nthFibonacci;
    }
}
