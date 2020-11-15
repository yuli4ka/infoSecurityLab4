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
        checkNumber(5, 20);
        checkNumber(6, 20);
        checkNumber(7, 20);
        checkNumber(8, 20);
        checkNumber(9, 20);
        checkNumber(10, 20);
        checkNumber(11, 20);
        checkNumber(12, 20);

    }

}
