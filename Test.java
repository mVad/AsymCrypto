import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tempuser on 27.09.2017.
 */
public class Test {
    private static void uniformityTest(int[] data, double alfa){
        double z = 0;
        if (alfa == 0.01) {
            z = 0.83891293878626816;
        } else if (alfa == 0.05) {
            z = 0.82894388796634644;
        } else if (alfa == 0.1) {
            z = 0.81593990850046572;
        }

        ArrayList<Integer> byteAmount = new ArrayList<Integer>();
        double xi2 = 0, xi2a = 0;
        int t = 0, l = 255;
        int n = data.length/256;

        int temp = 0;

        for(int i = 0; i < 256; i++){byteAmount.add(0);}
        for(int i = 0; i < data.length; i++){
            temp = data[i];
            byteAmount.set(temp, (byteAmount.get(temp)+1));
        }
        for(int i = 0; i < 256; i++){
            t = byteAmount.get(i);
            xi2 += Math.pow( (t - n), 2 )/n;
        }
        xi2a = Math.sqrt(2 * l) * z + l;
    }

    private static void independenceTest(int[] data, double alfa){
        double z = 0;
        if (alfa == 0.01) {
            z = 0.83891293878626816;
        } else if (alfa == 0.05) {
            z = 0.82894388796634644;
        } else if (alfa == 0.1) {
            z = 0.81593990850046572;
        }

        List<List<Integer>> byteAmount = new ArrayList<>();
        byteAmount.add(new ArrayList<Integer>());
        List<Integer> byteAmountFirst = new ArrayList<Integer>();
        List<Integer> byteAmountSecond = new ArrayList<Integer>();

        double xi2a = 0, xi2 = 0;
        int vij = 0, vi = 0, aj = 0;
        int n = data.length / 2;
        double l = Math.pow(255, 2);
        int first = 0, second = 0, xi2Temp = 0;

        for(int i = 0; i < 256; i++){
            for(int j = 0; j < 256; j++){
                byteAmount.get(i).add(0);
            }
        }
        for (int i = 0; i < 256; i ++) {
            byteAmountFirst.add(0);
        }
        for (int i = 0; i < 256; i ++) {
            byteAmountSecond.add(0);
        }
        for (int i = 0; i < data.length; i+=2) {
            first = data[i];
            second = data[i+1];

            byteAmountFirst.set(first, (byteAmountFirst.get(first)+1));
            byteAmountSecond.set(second, (byteAmountSecond.get(second)+1));
            byteAmount.get(first).set(second, (byteAmount.get(first).get(second)+1));
        }
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                vij = byteAmount.get(i).get(j);
                vi = byteAmountFirst.get(i);
                aj = byteAmountSecond.get(j);

                if (vi == 0) {	continue; }
                if (aj == 0) {	continue; }

                xi2Temp += Math.pow(vij, 2) / ( vi * aj );
            }
        }
        xi2 = n * (xi2Temp - 1);
        xi2a = Math.sqrt(2 * l) * z + l;
    }

    private static void homogeneityTest(int[] data, double alfa){
        double z = 0;
        if (alfa == 0.01) {
            z = 0.83891293878626816;
        } else if (alfa == 0.05) {
            z = 0.82894388796634644;
        } else if (alfa == 0.1) {
            z = 0.81593990850046572;
        }

        List<List<Integer>> byteAmountInSegment = new ArrayList<>();
        byteAmountInSegment.add(new ArrayList<Integer>());
        List<Integer> byteAmountFirst = new ArrayList<Integer>();
        int n = data.length;
        int r = 10;
        int m = n / r;
        double xi2a = 0, xi2 = 0;
        int l = 255 * ( r - 1 );
        int vij = 0;
        int vi = 0;
        int aj = m;
        int xi2Temp = 0, temp = 0;

        for (int i = 0; i < 256; i++) {
            byteAmountFirst.add(0);
        }

        for(int i = 0; i < 256; i++){
            for(int j = 0; j < 256; j++){
                byteAmountInSegment.get(i).add(0);
            }
        }

        for (int i = 0, j = 0; i < data.length; i++) {
            temp = data[i];
            byteAmountFirst.set(temp, (byteAmountFirst.get(temp)+1));
            if ((i != 0) && (i % m == 0)) {
                j++;
            }
            byteAmountInSegment.get(j).set(temp, (byteAmountInSegment.get(j).get(temp)+1));
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < 256; j++) {
                vij = byteAmountInSegment.get(i).get(j);;
                vi = byteAmountFirst.get(j);
                if (vi == 0) { continue; }
                if (aj == 0) { continue; }

                xi2Temp += Math.pow(vij, 2 ) / ( vi * aj);
            }
        }
        xi2 = n * (xi2Temp - 1);
        xi2a = Math.sqrt(2 * l) * z + l;
    }
}
