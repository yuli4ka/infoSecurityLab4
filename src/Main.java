import java.math.BigInteger;
import java.util.List;

public class Main {

    private static void checkNumber(int number, int numIteration) {
        if (MileraRabina.compositeNumber(BigInteger.valueOf(number), numIteration)) {
            System.out.println(number + " is composite");
        } else {
            System.out.println(number + " isn`t composite (no eto ne tochno)");
        }
    }

    private static void doMileraRabina() {
        //        for (int i = 2; i < 100; i++) {
////            checkNumber(i, 20);
////        }
//        prime:
        checkNumber(352123, 100);
        checkNumber(352021, 100);
        checkNumber(351863, 100);
        checkNumber(351061, 100);
        checkNumber(350347, 100);
        checkNumber(349183, 100);
//        not prime:
        checkNumber(352121, 100);
        checkNumber(352023, 100);
        checkNumber(351865, 100);
        checkNumber(351063, 100);
        checkNumber(350349, 100);
        checkNumber(349185, 100);
    }

    private static void doRSA() {
        BigInteger p = new BigInteger("5700734181645378434561188374130529072194886062117");
        BigInteger q = new BigInteger("35894562752016259689151502540913447503526083241413");
        BigInteger e = new BigInteger("33445843524692047286771520482406772494816708076993");
        String message = "I love cats";

        RSA rsa = new RSA(p, q, e);

        List<BigInteger> encrypted = rsa.encryptMessage(message);
        List<BigInteger> decrypted = rsa.decrypt(encrypted);

        System.out.println(Util.bigIntegerToString(decrypted));
    }

    public static void main(String[] args) {
        System.out.println("----- Milera Rabina -----");
        doMileraRabina();
        System.out.println();
        System.out.println("----- RSA -----");
        doRSA();
    }

}
