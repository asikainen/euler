/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.ArrayList;
import java.util.HashMap;
import project_euler.util.SieveOfAtkin;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem027 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        final int limit = 10000;
        final SieveOfAtkin sieve = new SieveOfAtkin(limit);
        final ArrayList<Integer> list = sieve.run();
        final HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int p : list) {
            map.put(p, map.size());
        }

        int maxlength = 0;
        int amax = 0;
        int bmax = 0;

        for (int a = -999; a < 1000; a++) {
            for (int i = 0; i < list.size(); i++) {
                final int b = list.get(i);
                if (b > 999) {
                    break;
                }
//                System.out.println("# a = " + a + "; b = " + b);
                int length = 0;
                for (int n = 0; n < 1000; n++) {
                    final int fn = n * n + a * n + b;
                    if (map.containsKey(fn)) {
                        length++;
//                        System.out.println(n + "\t" + fn);
                    } else {
                        break;
                    }
                }
                if (length > maxlength) {
                    maxlength = length;
                    amax = a;
                    bmax = b;
                    System.out.println("# a = " + amax + "; b = " + bmax + "; length = " + maxlength);
                }
            }
        }
        System.out.println("# a = " + amax + "; b = " + bmax + "; length = " + maxlength + "; a x b = " + (amax * bmax));
    }
}
//
// Euler published the remarkable quadratic formula:
//
// n² + n + 41
//
// It turns out that the formula will produce 40 primes for the consecutive
// values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41
// is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is
// clearly divisible by 41.
//
// Using computers, the incredible formula  n² - 79n + 1601 was discovered,
// which produces 80 primes for the consecutive values n = 0 to 79.
// The product of the coefficients, 79 and 1601, is 126479.
//
// Considering quadratics of the form:
//
// n² + an + b, where |a| < 1000 and |b| < 1000
//
// where |n| is the modulus/absolute value of n
// e.g. |11| = 11 and |-4| = 4
//
// Find the product of the coefficients, a and b, for the quadratic
// expression that produces the maximum number of primes for consecutive
// values of n, starting with n = 0.
//

