package lab2;

import java.math.BigInteger;

/**
 * Created by Tempuser on 24.10.2017.
 */
public class Abonent extends RSA {
    BigInteger p;
    BigInteger q;
    BigInteger d;
    BigInteger n;
    BigInteger e;

    public Abonent(BigInteger p, BigInteger q, BigInteger d, BigInteger n, BigInteger e) {
        this.p = p;
        this.q = q;
        this.d = d;
        this.n = n;
        this.e = e;
    }

    public BigInteger getP() {
        return p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getQ() {
        return q;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public BigInteger getD() {
        return d;
    }

    public void setD(BigInteger d) {
        this.d = d;
    }

    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getE() {
        return e;
    }

    public void setE(BigInteger e) {
        this.e = e;
    }

    public BigInteger encrypt(BigInteger msg, BigInteger openKey){
        return msg;
    }

}
