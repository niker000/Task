package task9;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class NumberPowerTest {

    @Test
    public void pow() {
        assertEquals(BigInteger.valueOf(25),NumberPower.pow(5,2));
    }
}