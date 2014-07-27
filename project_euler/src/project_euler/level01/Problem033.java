/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.ArrayList;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem033 {

    private final static int ACCURACY = 10;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        final ArrayList<Integer> nominators = new ArrayList<Integer>();
        final ArrayList<Integer> denominators = new ArrayList<Integer>();
        for (int i = 10; i < 100; i++) {
            final int[] digits1 = getDigits(i);
            for (int j = i + 1; j < 100; j++) {
                final int[] digits2 = getDigits(j);
                final String result1 = divide(i, j);
//                System.out.println(Arrays.toString(digits1) + " / " + Arrays.toString(digits2));
//                System.out.println(i + " / " + j + " = " + result1);
                int k = -1;
                int l = -1;
                if (digits1[0] == digits2[0]) {
                    k = digits1[1];
                    l = digits2[1];
                } else if (digits1[0] == digits2[1]) {
                    k = digits1[1];
                    l = digits2[0];
                } else if (digits1[1] == digits2[0]) {
                    k = digits1[0];
                    l = digits2[1];
                } else if (digits1[1] == digits2[0]) {
                    k = digits1[0];
                    l = digits2[0];
                }
                if (k > 0 && l > 0) {
                    final String result2 = divide(k, l);
//                    System.out.println(k + " / " + l + " = " + result2);
                    if (result1.equals(result2)) {
                        System.out.println("# magic numbers found; " + i + " / " + j + " = " + k + " / " + l);
                        nominators.add(k);
                        denominators.add(l);
                    }
                }
            }
        }

        int p1 = 1;
        int p2 = 2;
        for (int i = 0; i < nominators.size(); i++) {
            p1 *= nominators.get(i);
            p2 *= denominators.get(i);
        }
//        for (int i = 0; i < nominators.size(); i++) {
//            p1 = nominators.get(i);
//            for (int j = 0; j < nominators.size(); j++) {
//                p2 = denominators.get(i);
//                if (p1 > 1 && p2 % p1 == 0) {
//                    final int p = p2 / p1;
//                }
//            }
//        }
        System.out.println("# n = " + nominators.size() + "; p1 = " + p1 + "; p2 = " + p2);
    }

    private static int[] getDigits(int n) {
        String s = String.valueOf(n);
        int[] ints = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ints[i] = Integer.parseInt(s.substring(i, i + 1));
        }
        s = null;
        return ints;
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
            if (rem == 0) {
                break;
            }
            decimals++;
        }
        return sb.toString();
    }
}
//
// The fraction 49/98 is a curious fraction, as an inexperienced mathematician
// in attempting to simplify it may incorrectly believe that 49/98 = 4/8,
// which is correct, is obtained by cancelling the 9s.
//
// We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
//
// There are exactly four non-trivial examples of this type of fraction,
// less than one in value, and containing two digits in the numerator and
// denominator.
//
// If the product of these four fractions is given in its lowest common terms,
// find the value of the denominator.
//

