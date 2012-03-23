/*
 * Author: Colin Blower
 * Date: 2012-03-08
 */
import java.math.BigInteger;
public class Euler160
{
    public static long MOD = 100000;
    public static long BMOD = 10000000;
    public static long count = 0;

    public static void main(String[] args) {
        System.out.println(f(1000000000000l));
    }

    /*
     * Return a string representing the last 5 non-zero digits of n!.
     * @param n
     */
    public static String f(long n) {
        long twos = 0;
        long fives = 0;
        long t = n;
        // Count the factors of 2 in n
        while (t > 1) {
            t /= 2;
            twos += t;
        }
        t = n;
        // Count the factors of 5 in n
        while (t > 1) {
            t /= 5;
            fives += t;
        }

        // By subtracting we get rid of all the factors of 10 in n!
        long last = twos - fives;

        // We then multiply back the extra factors of 2
        BigInteger a = BigInteger.valueOf(2).modPow(BigInteger.valueOf(last), 
                                                    BigInteger.valueOf(MOD));
        BigInteger b = BigInteger.valueOf(fhelper(n));

        return a.multiply(b).mod(BigInteger.valueOf(MOD)).toString();
    }

    /*
     * Finds the value of the last 5 non-zero digits of n!.
     */
    public static long fhelper(long n) {
        if (n <= 0)
            return 1;
        // Separate into two parts, the odd numbers in n! and the even numbers.
        // Since we have already taken out the factors of 2 the evens can be
        // calculated by a recursive call.
        return (fodds(n) * fhelper(n/2)) % MOD;
    }

    /*
     * Product of all odd numbers less than or equal to n excluding factors of
     * five
     */
    public static long fodds(long n) {
        if (n <= 0)
            return 1;
        return (fodds(n/5) * fn5n2(n)) % MOD;
    }

    /*
     * Product of n! % MOD excluding factors of 5 or 2
     */
    public static long fn5n2(long n) {
        count++;
        long out = 1;
        n = n%MOD;
        for (long i = 1; i <= n; i++) {
            if (i%2!=0 && i%5!=0) 
                out = (i*out)%MOD;
        }
        return out;
    }
}
