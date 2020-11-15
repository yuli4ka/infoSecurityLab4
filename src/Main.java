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
        for (int i = 2; i < 100; i++) {
            checkNumber(i, 20);
        }
    }

}
