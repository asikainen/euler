/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem026 {

    private final static int ACCURACY = 3000;
    private final static int SCALE = 3000;

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        final int num = 1;
        final int denum = 983;
        final String result = divide(num, denum);
        System.out.println("# " + num + " / " + denum + " = " + result);
        final int c = computeLongestCycle(result.substring(2));
        System.out.println("# n = " + 1000 + "; max cycle length = " + c + "; d_max = " + denum);

        final BigDecimal one = BigDecimal.ONE;
        final int n = 1000;
        int maxc = 0;
        int maxd = 0;
        for (int d = 983; d < n; d++) {
            final BigDecimal dd = new BigDecimal(String.valueOf(d));
            final BigDecimal id = one.divide(dd, SCALE, RoundingMode.HALF_UP);
            final int cycle = computeLongestCycle(id.toString().substring(2));
            if (cycle >= maxc) {
                maxc = cycle;
                maxd = d;
                System.out.println("# " + dd + "\t" + String.valueOf(id));
                System.out.println("# d = " + d + "; longest cycle was " + cycle + "; max cycle = " + maxc);
            }
        }

        System.out.println("# n = " + n + "; max cycle length = " + maxc+ "; d_max = " + maxd);
    }

    private static int computeLongestCycle(String string) {
        final int length = string.length();
        int maxcycle = 0;
        int i = 0;
        char[] chars = string.toCharArray();
        for (i = 0; i < length; i++) {
            boolean same = true;
            char first = chars[i];
            int cycle = 0;
            for (int j = i + 1; j < string.length(); j++) {
                if (chars[j] != first) {
                    same = false;
                } else {
                    final int l = (j - i);
                    final boolean ok = equals(chars, i, i + l, l);
                    if (ok) {
                        cycle = l;
                        break;
                    }
                }
            }
            if (same) {
                cycle = 1;
            }
            if (cycle > maxcycle) {
                maxcycle = cycle;
            }
        }
        return maxcycle;
    }

    private static boolean equals(char[] chars, int start1, int start2, int length) {
        boolean equals = true;
        for (int i = start1; i < start1 + length; i++) {
            if (i + length >= chars.length) {
                equals = false;
                break;
            }
            if (chars[i] != chars[i + length]) {
                equals = false;
                break;
            }
        }
        return equals;
    }

    private static String divide(final int num, final int denum) {
        final StringBuilder sb = new StringBuilder();

        int result = num / denum;
        sb.append(result);
        sb.append(".");
        int decimals = 0;
        int rem = num - (result * denum);
        while (decimals < ACCURACY) {
            rem *= 10;
            result = rem / denum;
            rem %= denum;
            sb.append(result);
            decimals++;
        }
        return sb.toString();
    }
}
// A unit fraction contains 1 in the numerator. The decimal representation
// of the unit fractions with denominators 2 to 10 are given:
//
// 1/2	= 	0.5
// 1/3	= 	0.(3)
// 1/4	= 	0.25
// 1/5	= 	0.2
// 1/6	= 	0.1(6)
// 1/7	= 	0.(142857)
// 1/8	= 	0.125
// 1/9	= 	0.(1)
// 1/10	= 	0.1
//
// Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle.
// It can be seen that 1/7 has a 6-digit recurring cycle.
//
// Find the value of d < 1000 for which 1/d contains the longest
// recurring cycle in its decimal fraction part.

