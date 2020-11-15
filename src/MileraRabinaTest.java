import java.math.BigInteger;

class MileraRabinaTest {

    public static void main(String[] args) {
        aInTModNTest();
        getRandomTest();
    }

    static void aInTModNTest() {
        assert MileraRabina.aInTModN(BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(2)).equals(BigInteger.ZERO);
        assert MileraRabina.aInTModN(BigInteger.valueOf(2), BigInteger.valueOf(5), BigInteger.valueOf(10)).equals(BigInteger.TWO);
    }

    static void getRandomTest() {
        for (int i = 1; i < 100; i++) {
            BigInteger min = BigInteger.valueOf(4);
            BigInteger max = BigInteger. valueOf(100);
            BigInteger rand = MileraRabina.getRandom(min, max);
            assert min.compareTo(rand) <= 0;
            assert rand.compareTo(max) <= 0;
        }
    }
}