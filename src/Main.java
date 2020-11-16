import java.math.BigInteger;

public class Main {

    private static void checkNumber(int number, int numIteration) {
        if (MileraRabina.compositeNumber(BigInteger.valueOf(number), numIteration)) {
            System.out.println(number + " is composite");
        } else {
            System.out.println(number + " isn`t composite (no eto ne tochno)");
        }
    }

    public static void main(String[] args) {
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

}
