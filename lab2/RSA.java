package lab2;

import java.math.BigInteger;
import java.util.Random;

abstract class RSA {


    private static boolean isPseudoFerma(BigInteger p, BigInteger k) {
        BigInteger i = BigInteger.ZERO;
        if (p.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) return false;
        while (i.compareTo(k) != 0) {
         //   System.out.println("i=" + i.intValue());
            BigInteger x = new BigInteger(p.bitLength()-1, new Random());
            BigInteger result = x.gcd(p);
            if (result.compareTo(BigInteger.ONE) == 1) return false;
            if (result.compareTo(BigInteger.ONE) == 0 && x.modPow(p.divide(BigInteger.ONE), p).compareTo(BigInteger.ONE) == 0) {
                return false;
            }
            i = i.add(BigInteger.ONE);
        }
        return true;
    }

    private static BigInteger rnd(int min, int max) {
        //includeve [2^min;2^min+max]
        return new BigInteger(max, new Random()).multiply(BigInteger.valueOf(2).pow(min)).add(BigInteger.ONE);
    }

    static BigInteger pseudoFerma(int min, int max, BigInteger k) {
        BigInteger p=rnd(min,max);
        while (true){
            if (isPseudoFerma(p, k) && p.bitLength() == 256)
                return p;
            p=rnd(min,max);
        }
    }

    public static void main(String[] args) {

        BigInteger p = pseudoFerma(128,128,BigInteger.valueOf(2).pow(256));

    }
}
