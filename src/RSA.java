import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.*;

// http://www.michurin.net/computer-science/rsa.html
public class RSA {

    private final BigInteger d;
    private final BigInteger e;
    private final BigInteger n;

    RSA(BigInteger p, BigInteger q, BigInteger e) {
        BigInteger phi = (p.subtract(ONE)).multiply(q.subtract(ONE));
        this.e = e;
        this.n = p.multiply(q);
        this.d = e.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger bigInteger) {
        if (n.compareTo(bigInteger) < 0) {
            throw new IllegalArgumentException("message cannot be bigger than n");
        }
        return bigInteger.modPow(e, n);
    }

    public List<BigInteger> encryptMessage(String message) {
        List<BigInteger> encryptList = new ArrayList<>();
        BigInteger messageBytes = new BigInteger(message.getBytes());

        if (n.compareTo(messageBytes) < 0) {
            encryptList = getValidEncryptBlocks(Util.splitMessages(new ArrayList<>() {
                {
                    add(message);
                }
            }));
        } else {
            encryptList.add((messageBytes));
        }

        List<BigInteger> ans = new ArrayList<>();
        for (BigInteger bigInteger : encryptList) {
            ans.add(encrypt(bigInteger));
        }

        return ans;
    }

    public BigInteger decrypt(BigInteger bigInteger) {
        return bigInteger.modPow(d, n);
    }

    public List<BigInteger> decrypt(List<BigInteger> message) {
        List<BigInteger> ans = new ArrayList<>();
        for (BigInteger bigInteger : message) {
            ans.add(decrypt(bigInteger));
        }
        return ans;
    }

    private List<BigInteger> getValidEncryptBlocks(List<String> messages) {
        List<BigInteger> validBlocks = new ArrayList<>();
        BigInteger messageBytes = new BigInteger(messages.get(0).getBytes());
        if (n.compareTo(messageBytes) >= 0) {
            for (String msg : messages) {
                validBlocks.add(new BigInteger(msg.getBytes()));
            }
            return validBlocks;
        } else {
            return getValidEncryptBlocks(Util.splitMessages(messages));
        }
    }

}
