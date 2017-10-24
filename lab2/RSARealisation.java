package lab2;

import java.math.BigInteger;

/**
 * Created by vadim on 24.10.2017.
 */
public class RSARealisation {

    public static void GenerateKeyPair(Abonent A){
        A.setP(RSA.pseudoFerma(128,128, BigInteger.valueOf(2).pow(10)));
        A.setQ(RSA.pseudoFerma(128,128, BigInteger.valueOf(2).pow(10)));
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

    public static void main(String[] args){
        Abonent A = new Abonent();
        GenerateKeyPair(A);
        A.GenerateMessage();
        System.out.println(A.getMessage());
        BigInteger ciph = encryption(A);
        System.out.println(ciph);
        BigInteger plain = decryption(A, ciph);
        System.out.println(plain);

    }
}
