package lab2;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by vadim on 24.10.2017.
 */
public class RSARealisation {
    public static BigInteger encryption(Abonent A){
        return A.getMessage().modPow(A.getE(), A.getN());
    }

    public static BigInteger decryption(Abonent A, BigInteger ciphtext){
        return  ciphtext.modPow(A.getD(), A.getN());
    }

    public static BigInteger Sign(Abonent A){
        return A.getMessage().modPow(A.getD(), A.getN());
    }

    public static BigInteger Verify(Abonent A, BigInteger signedMessage){
        return signedMessage.modPow(A.getE(), A.getN());
    }

    public boolean protocol(Abonent A, Abonent B){
        A.sendData(B);
        //B.GenerateKeyPair();
        B.getData(A);
        return B.check(A);
    }
    public static void main(String[] args){
        Abonent A = new Abonent();
        A.GenerateKeyPair();
        A.GenerateMessage();
        System.out.println("plainText = " + A.getMessage());
        BigInteger ciph = encryption(A);
        System.out.println("cipherText = "+ciph);
        BigInteger plain = decryption(A, ciph);
        System.out.println("plainText = "+plain);
        BigInteger sign = Sign(A);
        System.out.println("Verify sign = "+Verify(A, sign));

        RSARealisation rsa = new RSARealisation();
//        Abonent A = new Abonent();
        Abonent B = new Abonent();
//        A.GenerateKeyPair();
        B.GenerateKeyPair();
        System.out.println("Result of method Protocol: "+rsa.protocol(A,B));

    }
}
