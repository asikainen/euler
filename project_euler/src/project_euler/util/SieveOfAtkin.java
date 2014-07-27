/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.util;

import java.util.ArrayList;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class SieveOfAtkin {

    private final int[] sieve;

    public SieveOfAtkin(int limit) {
        this.sieve = new int[limit + 1];
    }

    public ArrayList<Integer> run() {

        final int limit = sieve.length;
        for (int i = 0; i < limit; i++) {
            sieve[i] = 0;
        }
        sieve[2] = 1;
        sieve[3] = 1;
        final int end = (int) Math.sqrt((double) limit);

        for (int x = 1; x <= end; x++) {
            for (int y = 1; y <= end; y++) {
                final int x2 = x * x;
                final int y2 = y * y;
                int n = 4 * x2 + y2;
                if (n < limit && ((n % 12 == 1) || (n % 12 == 5))) {
                    //sieve[n] = 1;
                    if (sieve[n] == 0) {
                        sieve[n] = 1;
                    } else {
                        sieve[n] = 0;
                    }
                }
                n = 3 * x2 + y2;
                if (n < limit && ((n % 12 == 7))) {
//                    sieve[n] = 1;
                    if (sieve[n] == 0) {
                        sieve[n] = 1;
                    } else {
                        sieve[n] = 0;
                    }
                }
                if (x > y) {
                    n = 3 * x2 - y2;
                    if (n < limit && ((n % 12 == 1) || (n % 12 == 11))) {
//                        sieve[n] = 1;
                    if (sieve[n] == 0) {
                        sieve[n] = 1;
                    } else {
                        sieve[n] = 0;
                    }
                    }
                }
            }
        }

        for (int n = 5; n < end; n++) {
            if (sieve[n] > 0) {
                final int n2 = n * n;
                int k = n2;
                while (k <= limit) {
                    sieve[k] = 0;
                    k += n2;
                }
            }
        }

        final ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < limit; i++) {
            if (sieve[i] > 0) {
                list.add(i);
            }
        }
        return list;
    }
}
