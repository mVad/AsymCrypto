import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Generators {
    private static int unsignedToBytes(byte b) { return b & 0xFF; }
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
            if (x > 'a' && x<'z')
            array.add((int)x);
        }
        for (Integer xe: array)
            System.out.println(xe);
        return array;
    }

    static long volfram(long r0){


        long r1 = Long.parseUnsignedLong(String.valueOf(r0));
        long rotatedRight = Integer.toUnsignedLong(Integer.rotateRight((int)r1,1));
        long rotatedLeft = Integer.toUnsignedLong(Integer.rotateLeft((int)r1,1));
       // return Long.parseUnsignedLong(String.valueOf((rotatedLeft ^ (r1 | rotatedRight))));
       // System.out.println("rotatedRight "+rotatedRight
       // + "\nrotatedLeft"+rotatedLeft);
      //  System.out.println("without %=" + (rotatedLeft ^ (r1 | rotatedRight)));
       // System.out.println("with %0=" + (long)((rotatedLeft ^ (r1 | rotatedRight))% Math.pow(2,32)));
        return (long)((rotatedLeft ^ (r1 | rotatedRight))% Math.pow(2,32));


    }


    static BigInteger BM(BigInteger Tstart, BigInteger a, BigInteger p) {
        return a.modPow(Tstart, p);
    }

  static BigInteger BBS(BigInteger rStart, BigInteger pq) {
        return rStart.modPow(BigInteger.valueOf(2), pq);

    }


}
