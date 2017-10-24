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
    public static void main(String[] args){
        Abonent A = new Abonent();
        GenerateKeyPair(A);
    }
}
