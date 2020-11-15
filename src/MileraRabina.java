import java.math.BigInteger;
import java.util.Random;

public class MileraRabina {

    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = BigInteger.TWO;


    public static boolean compositeNumber(BigInteger n, int k) {
        if (n.compareTo(BigInteger.valueOf(4)) < 0) {
            return false;
        }
        if (n.mod(TWO).equals(ZERO)) {
            return true;
        }

        BigInteger t = n.subtract(ONE);
        BigInteger s = ZERO;
        while (t.mod(TWO).equals(ZERO)) {
            s = s.add(ONE);
            t = t.divide(TWO);
        }

//        System.out.println(n.subtract(ONE) + " = 2^" + s + "*" + t);

        A:
        for (int i = 0; i < k; i++) {
            BigInteger a = getRandom(TWO, n.subtract(TWO));
            BigInteger x = aInTModN(a, t, n);
            if (x.equals(ONE) || x.equals(n.subtract(ONE))) {
                continue;
            }
            for (BigInteger j = ZERO; j.compareTo(s.subtract(ONE)) < 0; j = j.add(ONE)) {
                x = aInTModN(x, TWO, n);
                if (x.equals(ZERO)) {
                    return true;
                }
                if (x.equals(n.subtract(ONE))) {
                    continue A;
                }
            }
            return true;
        }

        return false;
    }

    //  (a^t) mod n
    public static BigInteger aInTModN(BigInteger a, BigInteger t, BigInteger n) {
        BigInteger ans = ONE;
        for (BigInteger i = ONE; i.compareTo(t) <= 0; i = i.add(ONE)) {
            ans = ans.multiply(a);
        }
        return ans.mod(n);
    }

    //    number from [2, n-2]
    public static BigInteger getRandom(BigInteger min, BigInteger max) {
        BigInteger bigInteger = max.subtract(min);
        Random random = new Random();
        int len = max.bitLength();
        BigInteger res = new BigInteger(len, random);
        if (res.compareTo(min) < 0) {
            res = res.add(min);
        }
        if (res.compareTo(bigInteger) >= 0) {
            res = res.mod(bigInteger).add(min);
        }
        return res;
    }

}
