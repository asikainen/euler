/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.ArrayList;
import project_euler.util.SieveOfAtkin;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem050 {

    public static void main(String[] args) {
        final int max = 1000000;
        final SieveOfAtkin sieve = new SieveOfAtkin(max);
        final ArrayList<Integer> list = sieve.run();

        int result = 0;
        int nmax = 0;
        final int imax = list.size() - 1;
        for (int i = imax; i > 0; i--) {
            final int prime = list.get(i);
            final int n = findLongestConsecutive(i, prime, list);
            if (n > nmax) {
                nmax = n;
                result = prime;
            }
        }

        System.out.println("# result = " + result + "; nmax = " + nmax);
    }

    private static int findLongestConsecutive(int index, int prime, ArrayList<Integer> list) {
        int nmax = 0;
        for (int start = 0; start < index; start++) {
            int i = start;
            int sum = 0;
            int n = 0;
            while (sum < prime && i < index) {
                sum += list.get(i);
                n++;
                i++;
            }
            if (sum == prime) {
                if (n > nmax) {
                    nmax = n;
                }
            }
        }
        return nmax;
    }
}
//
// The prime 41, can be written as the sum of six consecutive primes:
//
// 41 = 2 + 3 + 5 + 7 + 11 + 13
// This is the longest sum of consecutive primes that adds to a prime
// below one-hundred.
//
// The longest sum of consecutive primes below one-thousand that adds to
// a prime, contains 21 terms, and is equal to 953.
//
// Which prime, below one-million, can be written as the sum of the
// most consecutive primes?
//

