package lab2;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Tempuser on 24.10.2017.
 */
public class Abonent extends RSA {
    private BigInteger p;
    private BigInteger q;
    private BigInteger d;
    private BigInteger n;
    private BigInteger e;
    private BigInteger message;
    private BigInteger k;
    private BigInteger s;


    public void GenerateKeyPair(){

     //  this.setP(BigInteger.probablePrime(256, new Random()));
       // this.setQ(BigInteger.probablePrime(256, new Random()));
        this.setP(pseudoFerma(128,128,BigInteger.valueOf(2).pow(10)));
        this.setQ(pseudoFerma(128,128,BigInteger.valueOf(2).pow(10)));
        this.setN(this.getP().multiply(this.getQ()));
        this.setE(BigInteger.valueOf(65537));
        this.setD(this.getE().modInverse(this.phiN()));
    }

    BigInteger getP() {
        return p;
    }

    void setP(BigInteger p) {
        this.p = p;
    }

    BigInteger getQ() {
        return q;
    }

    void setQ(BigInteger q) {
        this.q = q;
    }

    BigInteger getD() {
        return d;
    }

    void setD(BigInteger d) {
        this.d = d;
    }

    BigInteger getN() {
        return n;
    }

    void setN(BigInteger n) {
        this.n = n;
    }

    BigInteger getE() {
        return e;
    }

    void setE(BigInteger e) {
        this.e = e;
    }

    public BigInteger phiN(){
        return (this.getP().subtract(BigInteger.ONE)).multiply(this.getQ().subtract(BigInteger.ONE));
    }
    public void setMessage(BigInteger message){
        this.message = message;
    }
    public BigInteger getMessage(){
        return this.message;
    }
    public void GenerateMessage(){
        this.setMessage(BigInteger.probablePrime(200, new Random()));
    }



    private void setK(BigInteger k) {
        this.k = k;
    }
    private BigInteger getK() {
        return k;
    }

    public BigInteger getS() {
        return s;
    }

    public void setS(BigInteger s) {
        this.s = s;
    }

    void sendData(Abonent B){
        while (B.getN().compareTo(this.getN()) == -1) this.GenerateKeyPair();
        this.setK(BigInteger.valueOf(10));
        BigInteger k1 = this.getK().modPow(B.getE(),B.getN());
        B.setK(k1);
        BigInteger s = this.getK().modPow(this.getD(),this.getN());
        BigInteger s1 = s.modPow(B.getE(),B.getN());
        B.setS(s1);

    }
    void getData(Abonent A){
        this.setK(this.getK().modPow(this.getD(),this.getN()));
        this.setS(this.getS().modPow(this.getD(),this.getN()));
    }

    boolean check(Abonent A){
        return this.getK().compareTo(this.getS().modPow(A.getE(), A.getN())) == 0;
    }

}
