/*
 * My general approach to this problem was to just create the irrational
 * decimal as a string, then pull out the relevant digits, and multiply. Using
 * StringBuilder instead of String concatenation makes the program run
 * significantly faster.
 *
 * Author: Colin Blower
 * Date: 2012-03-08
 */
public class Euler040
{
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        long i = 0;
        while (str.length() <= 1000000) {
            str.append(i);
            i++;
        }
        String s = str.toString();
        int a = 1;
        long out = 1;
        for (int j = 0; j < 7; j++) {
            out *= (s.charAt(a)-'0');
            //System.out.println(s.charAt(a));
            a = a * 10;
        }
        System.out.println(out);
    }
}
