package lab2;

import java.math.BigInteger;
import java.util.Random;

public class RSA {

    private static long GCD(long a, long b)
    {
        while (b != 0)
            b = a % (a = b);
        return a < 0 ? -a : a;
    }

    static boolean isPseudoFerma(int p, int k) {
        int i = 0;
        if (p % 2 == 0) return false;
        while (i < k) {
            int x = new Random().nextInt(p - 1) + 1;
            if (GCD(x, p) > 1) return false;
            if (GCD(x, p) != 1 || BigInteger.valueOf(x).modPow(BigInteger.valueOf(p - 1), BigInteger.valueOf(p)).intValue() != 1) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPseudoFerma(7,1));
    }
}
