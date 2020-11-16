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

    private static void doRSA(BigInteger p, BigInteger q, BigInteger e, String message) {
        RSA rsa = new RSA(p, q, e);
        List<BigInteger> encrypted = rsa.encryptMessage(message);
        List<BigInteger> decrypted = rsa.decrypt(encrypted);
        System.out.println(Util.bigIntegerToString(decrypted));
    }

    private static void checkRSAOnTime(BigInteger p, BigInteger q, BigInteger e, String message) {
        long startTime = System.nanoTime();

        int n = 100;
        for (int i = 0; i < n; i++) {
            doRSA(p, q, e, message);
        }

        long endTime = System.nanoTime();
        System.out.println("for p = " + p + "\nq = " + q + "\ne = " + e + "\n time: " +
                ((endTime - startTime) / 1000000.0) / n + " milliseconds");
    }

    private static void checkRSA() {
        checkRSAOnTime(new BigInteger("5700734181645378434561188374130529072194886062117"),
                new BigInteger("35894562752016259689151502540913447503526083241413"),
                new BigInteger("33445843524692047286771520482406772494816708076993"),
                "I love cats");
        checkRSAOnTime(new BigInteger("99999570073418164537843456118837413052"),
                new BigInteger("99999358945627520162596891515025409132"),
                new BigInteger("334458435246920472867715204824"),
                "I love cats");
        checkRSAOnTime(new BigInteger("9900734181645378434561118347878787787843971231218743578943589734578934578934589743587976326723673246734267423672346724367784379439874378778887788777874378"),
                new BigInteger("9900734181645378434561118347878787787843971231218743578943589734578934578934589743587976326723673246734267423672346724367784379439874378778887788777874378"),
                new BigInteger("334458435246920472867715204824067724948167348454898498548893894983749839898598398395893859894893859874590807"),
                "I love cats");
        checkRSAOnTime(new BigInteger("99007341845894589459458945895489458945894589549845985489458945894589548498458945894598548954895489549858837413052907219488606098349834784578459839834094309430349843984854784587457845893489430943047873898979784389743874358955358893458975435879763623673246734267423672346724367784379439874378778887788777874382"),
                new BigInteger("99894596891515020954094590450994590540954904509450945090594094509540950954090945094509490459050499054540919999999999993984398349834984389348943893498348943784378745675956985687348734879839494393394834984378437474348948999993498349834895345944445598437598724892965837465743692498259384695246924989698234698249"),
                new BigInteger("3344584352469204728677152048240677458359385798378579837979847374398759834787443987574358345897349873478249481670807"),
                "I love cats");
    }

    public static void main(String[] args) {
        System.out.println("----- Milera Rabina -----");
        doMileraRabina();
        System.out.println();
        System.out.println("----- RSA -----");
        checkRSA();
    }

}
