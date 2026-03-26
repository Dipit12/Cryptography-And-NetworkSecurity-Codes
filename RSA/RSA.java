import java.math.*;
import java.util.*;

public class RSA {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int modInverse(int e, int phi) {
        for (int d = 2; d < phi; d++) {
            if ((d * e) % phi == 1) {
                return d;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the prime number p");
        int p = input.nextInt();
        System.out.println("Enter the prime number q");
        int q = input.nextInt();

        // compute n and phi(n)
        int n = p * q;
        int phi = (p - 1) * (q - 1);
        int e;
        // choose e such that 1 < e < phi(n)
        for (e = 2; e < phi; e++) {
            if (gcd(e, phi) == 1) {
                break;
            }
        }

        // compute d such that d * e % phi(n) == 1
        int d = modInverse(e, phi);

        System.out.println("Public key is {" + e + ", " + n + "}");
        System.out.println("Private key is {" + d + ", " + n + "}");

        // encrypt and decrypt a message
        System.out.println("Enter the message to encrypt");
        BigInteger message = new BigInteger(input.next());
        BigInteger e_bi = new BigInteger(String.valueOf(e));
        BigInteger n_bi = new BigInteger(String.valueOf(n));
        BigInteger d_bi = new BigInteger(String.valueOf(d));
        BigInteger encrypted = message.modPow(e_bi, n_bi);
        BigInteger decrypted = encrypted.modPow(d_bi, n_bi);
        System.out.println("Encrypted message is {" + encrypted + "}");
        System.out.println("Decrypted message is {" + decrypted + "}");
    }
}
