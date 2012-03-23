/**
 * Author: Colin Blower
 */
import java.math.BigInteger;

public class Euler005 {
    public static void main(String[] args) {
        long div = 1l;

        for(int i = 1; i <= 20; i++) {
            long med = div%i; 
            if (med != 0) {
                if (i%med == 0) {
                    div = div * (i/med);
                } else {
                    div = div * i;
                }
            }
        }

        System.out.println(div);
    }
}
