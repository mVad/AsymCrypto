package lab2;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by vadim on 24.10.2017.
 */
public class RSARealisation {

    public static void GenerateKeyPair(Abonent A){
        A.setP(BigInteger.probablePrime(256, new Random()));
        A.setQ(BigInteger.probablePrime(256, new Random()));
        A.setN(A.getP().multiply(A.getQ()));
        A.setE(BigInteger.valueOf(65537));
        A.setD(A.getE().modInverse(A.phiN()));
    }

    public static BigInteger encryption(Abonent A){
        BigInteger ciphtext;
        ciphtext = A.getMessage().modPow(A.getE(), A.getN());
        return ciphtext;
    }

    public static BigInteger decryption(Abonent A, BigInteger ciphtext){
        BigInteger plaintext;
        plaintext = ciphtext.modPow(A.getD(), A.getN());
        return  plaintext;
    }

    public static BigInteger Sign(Abonent A){
        BigInteger signedMessage;
        signedMessage = A.getMessage().modPow(A.getD(), A.getN());
        return signedMessage;
    }

    public static BigInteger Verify(Abonent A, BigInteger signedMessage){
        BigInteger verifyText;
        verifyText = signedMessage.modPow(A.getE(), A.getN());
        return verifyText;
    }

    public static void main(String[] args){
        Abonent A = new Abonent();
        GenerateKeyPair(A);
        A.GenerateMessage();
        System.out.println(A.getMessage());
        BigInteger ciph = encryption(A);
        System.out.println(ciph);
        BigInteger plain = decryption(A, ciph);
        System.out.println(plain);
        BigInteger sign = Sign(A);
        System.out.println(Verify(A, sign));
        

        //System.out.println(A.getD().multiply(A.getE()).mod(A.phiN()));
        //System.out.println(A.getE());

    }
}
