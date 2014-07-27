/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.util;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class PrimeFactors {

    private final static int max = 1000000;
    private final static SieveOfAtkin sieve;
    private final static ArrayList<Integer> primes;

    static {
        sieve = new SieveOfAtkin(max);
        primes = sieve.run();
    }

    public static HashMap<Integer, Integer> get(int number) {
        if (number > max) {
            return null;
        }
        final int start = 2;
        final int end = number;
        final HashMap<Integer, Integer> pfs = new HashMap<Integer, Integer>();
        while (number >= start) {
            for (int n = 0; n < primes.size(); n++) {
                int pf = primes.get(n);
                if (number < start) {
                    break;
                }
                if (pf > end) {
                    break;
                }
                if (!isDivisible(number, pf)) {
                    continue;
                } else {
                    int cnt = 1;
                    if (pfs.containsKey(pf)) {
                        cnt += pfs.get(pf);
                    }
                    pfs.put(pf, cnt);
                    number /= pf;
                }
            }
        }
        return pfs;
    }

    private static boolean isDivisible(final int number, final int divisor) {
        return (number == ((number / divisor) * divisor));
    }
}
