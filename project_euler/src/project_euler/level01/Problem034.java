/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem034 {

    public static void main(String[] args) {

        try {
            final int max = 100000000;
            int[] factorials = null;
            int total = 0;
            for (int n = 10; n < max; n++) {
                final int[] digits = getDigits(n);
                factorials = new int[digits.length];
                int sf = 0;
                for (int i = 0; i < digits.length; i++) {
                    final int d = digits[i];
                    final int f = factorial(d);
                    factorials[i] = f;
                    sf += f;
                }
//                System.out.println(n + "\t" + sf + "\t" + Arrays.toString(digits) + "\t" + Arrays.toString(factorials));
                if (sf == n) {
                    total += n;
                    System.out.println(n + "\t" + Arrays.toString(digits) + "\t" + Arrays.toString(factorials));
                }
            }
            System.out.println("# max = " + max + "; total = " + total);
        } catch (Exception ex) {
            Logger.getLogger(Problem034.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int factorial(int n) throws Exception {
        if (n < 0 || n > 16) {
            throw new Exception("factorial(int): argument out of range " + n + "; min = 0; max = 16;");
        } else if (n == 0) {
            return 1;
        }
        int f = n;
        while ((--n) > 0) {
            f *= n;
        }
        return f;
    }

    public static long factorial(long n) throws Exception {
        if (n < 0 || n > 20) {
            throw new Exception("factorial(long): argument out of range " + n + "; min = 0; max = 20;");
        } else if (n == 0) {
            return 1L;
        }
        long f = n;
        while ((--n) > 0) {
            f *= n;
        }
        return f;
    }

    public static int[] getDigits(int number) {
        final String str = String.valueOf(number);
        final int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            final int digit = Integer.parseInt(str.substring(i, i + 1));
            digits[i] = digit;
        }
        return digits;
    }
}
//
// 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
//
// Find the sum of all numbers which are equal to the sum of the factorial of
// their digits.
//
// Note: as 1! = 1 and 2! = 2 are not sums they are not included.
//

