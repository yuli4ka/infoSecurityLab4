import java.math.BigInteger;

class MileraRabinaTest {

    public static void main(String[] args) {
        getRandomTest();
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