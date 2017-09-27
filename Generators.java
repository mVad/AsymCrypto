import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;

/**
 * Created by Tempuser on 27.09.2017.
 */

public class Generators {
    protected static byte[] buildedGen(int length){
        byte randomBytes[] = new byte[length];
        new Random().nextBytes(randomBytes);
        return randomBytes;
    }

    protected static int lehmer(int x){
        return (int)(((Math.pow(2,16)+1)*x+119) % Math.pow(2,32));
    }

    protected static int l20(int x){
        return (x>>17)^(x>>15)^(x>>11)^(x) & 1;
    }

    protected static BigInteger l89(BigInteger x) {
    return x.shiftRight(51).xor(x.shiftRight(89)).and(BigInteger.ONE);
}
    protected static byte giffe(int x, int y, int s){
        return (byte) ((s&x) ^ ((1 ^ s)&y));
    }
    protected static List<Integer> bibliotekar(String text){
        List<Integer> array = new ArrayList<>();
        for (char x: text.toCharArray()){
            array.add((int)x);
        }
        return array;
    }

    protected static List<Integer> volfram(int r0, int n){
        int r = r0;
        List<Integer> mass = new ArrayList<>();
        for (int i=0;i<n;i++){
            mass.add((int)r%2);
            r = (r << 1) ^ (r | (r >> 1));
        }
        return mass;
    }


    protected static BigInteger BM(BigInteger Tstart,BigInteger a,BigInteger p) {
        BigInteger T = a.modPow(Tstart, p);
        return T;
    }

    protected static BigInteger BBS(BigInteger rStart, BigInteger pq) {
        BigInteger r = rStart.modPow(BigInteger.valueOf(2), pq);
        BigInteger x = r.mod(BigInteger.valueOf(2));
        return x;
    }

    protected static BigInteger BBSbytes(int r0) {
        if (r0<2) return BigInteger.ZERO;
        BigInteger rStart = BigInteger.valueOf(r0);
        BigInteger p = new BigInteger("0D5BBB96D30086EC484EBA3D7F9CAEB07", 16);
        BigInteger q = new BigInteger("425D2B9BFDB25B9CF6C416CC6E37B59C1F", 16);
        BigInteger r = rStart.modPow(BigInteger.valueOf(2),p.multiply(q));
        BigInteger x = r.mod(BigInteger.valueOf(256));
        return x;
    }

}
