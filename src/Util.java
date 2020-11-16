import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<String> splitMessages(List<String> messages) {
        List<String> ans = new ArrayList<>(messages.size() * 2);
        for (String message : messages) {
            int half = (int) Math.ceil(((double) message.length()) / ((double) 2));
            ans.add(message.substring(0, half));
            if (half < message.length()) {
                ans.add(message.substring(half));
            }
        }
        return ans;
    }

    public static String bigIntegerToString(List<BigInteger> list) {
        StringBuilder plainText = new StringBuilder();
        for (BigInteger bigInteger : list) {
            plainText.append(new String(bigInteger.toByteArray()));
        }
        return plainText.toString();
    }

}
