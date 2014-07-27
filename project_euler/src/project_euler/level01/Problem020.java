/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.math.BigInteger;

/**
 * Problem 020 ratkaisee Project Eulerin 20. tehtavan.
 * 
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem020 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final int n = 100;
        final BigInteger bi = factorial(String.valueOf(n));
        final String digits = bi.toString();
        int sum = 0;
        for (int i = 0; i < digits.length(); i++) {
            final String digit = digits.substring(i, i + 1);
            final int number = Integer.parseInt(digit);
            sum += number;
        }
        System.out.println("# " + n + "!; sum of digits = " + sum);
    }

    /**
     *
     * @param sn factorial() funktio laskee luvun <i>sn</i> kertoman.
     * @return luvun <i>sn</i> kertoma.
     */
    private static BigInteger factorial(String sn) {
        BigInteger f = BigInteger.ONE;
        final int n = Integer.parseInt(sn);
        for (int i = 1; i <= (int) n; i++) {
            BigInteger b = new BigInteger(String.valueOf(i));
            f = f.multiply(b);
        }
        return f;
    }
}
//
//n! means n  (n  1)  ...  3  2  1
//
//Find the sum of the digits in the number 100!