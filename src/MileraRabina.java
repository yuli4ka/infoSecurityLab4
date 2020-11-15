import java.math.BigInteger;

public class MileraRabina {

    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = BigInteger.TWO;


    public static boolean compositeNumber (BigInteger number, int k) {
        if (number.compareTo(BigInteger.valueOf(3)) < 0) {
            return false;
        }
        if (number.mod(TWO).equals(ZERO)) {
            return true;
        }

        BigInteger t = number.subtract(ONE);
        BigInteger s = ZERO;
        while (t.mod(TWO).equals(ZERO)) {
            s = s.add(ONE);
            t = t.divide(TWO);
        }

        System.out.println(number.subtract(ONE) + " = 2^" + s + "*" + t);

//        for (int i = 0; i < k; i++) {
//
//        }


        return false;
    }

}
