/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem043 {

    private final static long[] divisors = new long[]{2, 3, 5, 7, 11, 13, 17};
    private static long result = 0;
    private static int level = -1;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        final int n = 10;
        final int[] v = new int[n];
        visit(v, n, 0);
//        final int[] v = new int[]{1, 4, 0, 6, 3, 5, 7, 2, 8, 9};
//        check(v);
        System.out.println("# result = " + result);
    }

    private static void visit(int[] v, int n, int k) {

        level = level + 1;
        v[k] = level;

        if (level == n) {
            check(v);
        } else {
            for (int i = 0; i < n; i++) {
                if (v[i] == 0) {
                    visit(v, n, i);
                }
            }
        }

        level = level - 1;
        v[k] = 0;
    }

    private static long[] getThreeDigitSubs(int[] v) {
        final long[] subs = new long[v.length - 2];
        final String str = toString(v, -1);
//        System.out.println(subs.length + "\t " + str);
        for (int i = 1; i < v.length - 2; i++) {
            final String sub = str.substring(i, i + 3);
//            System.out.println(i + "\t " + sub);
            subs[i - 1] = Long.parseLong(sub);
        }
        subs[subs.length - 1] = Long.parseLong(str);
        return subs;
    }

    private static String toString(int[] v, int increment) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < v.length; i++) {
            sb.append(v[i] + increment);
        }
        return sb.toString();
    }

    private static void check(int[] v) {

        final long[] subs = getThreeDigitSubs(v);
        boolean divisibles = true;
        for (int i = 0; i < divisors.length; i++) {
            if (!isDivisible(subs[i], divisors[i])) {
                divisibles = false;
                break;
            }
        }
        if (divisibles) {
            System.out.println("# PD number " + subs[subs.length - 1]);
            result += subs[subs.length - 1];
        }
    }

    private static boolean isDivisible(final long number, final long divisor) {
//        System.out.println(number + "\t" + divisor);
        return (number == ((number / divisor) * divisor));
    }
}
//
// The number, 1406357289, is a 0 to 9 pandigital number because it is made
// up of each of the digits 0 to 9 in some order, but it also has a rather
// interesting sub-string divisibility property.
//
// Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way,
// we note the following:
//
// d2d3d4=406 is divisible by 2
// d3d4d5=063 is divisible by 3
// d4d5d6=635 is divisible by 5
// d5d6d7=357 is divisible by 7
// d6d7d8=572 is divisible by 11
// d7d8d9=728 is divisible by 13
// d8d9d10=289 is divisible by 17
//
// Find the sum of all 0 to 9 pandigital numbers with this property
//

