/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem038 {

    private final static int min = 123456789;
    private final static int max = 987654321;

    public static void main(String[] args) {

        int maxr = 0;
        int maxb = 0;
        int maxn = 0;
        for (int b = 1; b < 10000000; b++) {
            final StringBuilder sb = new StringBuilder();
            int n = 0;
            int r = 0;
            while (r != -1) {
                final int number = b * (++n);
                sb.append(number);
                r = isPanDigital(sb);
                if (r > 0 && n > 1) {
                    if (r > maxr) {
                        maxr = r;
                        maxb = b;
                        maxn = n;
                    }
                    System.out.println("# r = " + r + "; b = " + b + "; n = " + n);
                }
            }
        }
        System.out.println("# maxr = " + maxr + "; maxb = " + maxb + "; maxn = " + maxn);
    }

    private static int isPanDigital(final StringBuilder sb) {
        if (sb.length() > 9) {
            return -1;
        } else if (sb.length() < 9) {
            return -2;
        }
        final int num = Integer.parseInt(sb.toString());
        if (num > max) {
            return -3;
        } else if (num < min) {
            return -4;
        }
        final int[] dst = new int[10];
        for (int n = 0; n < sb.length(); n++) {
            final String s = sb.substring(n, n + 1);
            final int m = Integer.parseInt(s);
            if (m == 0) {
                return -5;
            }
            dst[m]++;
            if (dst[m] > 1) {
                return -6;
            }
        }
        return num;
    }

    private static boolean isPanDigital(int number) {
        final StringBuilder sb = new StringBuilder();
        sb.append(number);
        if (sb.length() != 9) {
            return false;
        }
        final int num = Integer.parseInt(sb.toString());
        if (num < min || num > max) {
            return false;
        }
        final int[] dst = new int[10];
        for (int n = 0; n < sb.length(); n++) {
            final String s = sb.substring(n, n + 1);
            final int m = Integer.parseInt(s);
            dst[m]++;
            if (dst[m] > 1) {
                return false;
            }
        }
        return true;
    }
}
// Take the number 192 and multiply it by each of 1, 2, and 3:
//
// 192 x 1 = 192
// 192 x 2 = 384
// 192 x 3 = 576
//
// By concatenating each product we get the 1 to 9 pandigital, 192384576.
// We will call 192384576 the concatenated product of 192 and (1,2,3)
//
// The same can be achieved by starting with 9 and multiplying by
// 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the
// concatenated product of 9 and (1,2,3,4,5).
//
// What is the largest 1 to 9 pandigital 9-digit number that can be
// formed as the concatenated product of an integer with
// (1,2, ... , n) where n > 1?
//

