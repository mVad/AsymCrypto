import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Generators {
    static byte[] buildedGen(int length){
        byte randomBytes[] = new byte[length];
        new Random().nextBytes(randomBytes);
        return randomBytes;
    }

    static int lehmer(BigInteger x, BigInteger a, BigInteger m){
        return (a.multiply(x).add(BigInteger.valueOf(119))).mod(m).intValue();
    }



    static byte giffe(int x, int y, int s){
        return (byte) ((s&x) ^ ((1 ^ s)&y));
    }
    static List<Integer> bibliotekar(String text){
        List<Integer> array = new ArrayList<>();
        for (char x: text.toCharArray()){
            array.add((int)x);
        }
        return array;
    }

    static int volfram(int r0){
        return ((r0 << 1) ^ (r0 | (r0 >>> 1)));
    }


    static BigInteger BM(BigInteger Tstart, BigInteger a, BigInteger p) {
        return a.modPow(Tstart, p);
    }

  static BigInteger BBS(BigInteger rStart, BigInteger pq) {
        return rStart.modPow(BigInteger.valueOf(2), pq);

    }


}
