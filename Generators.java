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

    static int lehmer(int x){
        return (int)(((Math.pow(2,16)+1)*x+119) % Math.pow(2,32));
    }

    static int l20(int x){
        return (x>>17)^(x>>15)^(x>>11)^(x) & 1;
    }

    protected static BigInteger l89(BigInteger x) {
    return x.shiftRight(51).xor(x.shiftRight(89)).and(BigInteger.ONE);
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

    protected static List<Integer> volfram(int r0, int n){
        int r = r0;
        List<Integer> mass = new ArrayList<>();
        for (int i=0;i<n;i++){
            mass.add(r %2);
            r = (r << 1) ^ (r | (r >> 1));
        }
        return mass;
    }


    static BigInteger BM(BigInteger Tstart, BigInteger a, BigInteger p) {
        return a.modPow(Tstart, p);
    }

  static BigInteger BBS(BigInteger rStart, BigInteger pq) {
        BigInteger r = rStart.modPow(BigInteger.valueOf(2), pq);
        return r.mod(BigInteger.valueOf(2));
    }


}
