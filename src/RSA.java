import java.math.BigInteger;

import static java.math.BigInteger.*;

// http://www.michurin.net/computer-science/rsa.html
public class RSA {

    private BigInteger d;
    private BigInteger e;
    private BigInteger n;
    private BigInteger p;
    private BigInteger q;
    private final BigInteger phi;

    RSA(BigInteger p, BigInteger q, BigInteger e) {
        phi = (p.subtract(ONE)).multiply(q.subtract(ONE));
        this.p = p;
        this.q = q;
        this.e = e;
        this.n = p.multiply(q);
        this.d = e.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger message) {
        if (n.compareTo(message) < 0) {
            throw new IllegalArgumentException("message cannot be bigger than n");
        }
        return message.modPow(e, n);
    }

}
