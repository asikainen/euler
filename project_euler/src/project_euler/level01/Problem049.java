/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import project_euler.util.Functions;
import project_euler.util.SieveOfAtkin;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem049 {

    public static void main(String[] args) {
        final SieveOfAtkin sieve = new SieveOfAtkin(10000);
        final int max = 10000;
        final ArrayList<Integer> list = sieve.run();
        final HashMap<Integer, Integer> primes = new HashMap<Integer, Integer>();
        for (int prime : list) {
            primes.put(prime, primes.size());
        }
        final int imax = list.size();
        for (int i = 0; i < imax; i++) {
            final int prime1 = list.get(i);
            if (prime1 > 1000 && prime1 < 10000) {
                final int prime2 = prime1 + 3330;
                final int prime3 = prime2 + 3330;
                if (primes.containsKey(prime2) && primes.containsKey(prime3)) {
                    if (arePermutations(prime1, prime2, prime3)) {
//                        System.out.println(i + "\t" + prime1 + "\t" + prime2 + "\t" + prime3);
                        System.out.println(i + "\t" + prime1 + "" + prime2 + "" + prime3);
                    }
                }
            }
        }
//        System.out.println(arePermutations(1487, 4817, 8147));
    }

    private static boolean arePermutations(int n1, int n2, int n3) {
        final int[] v1 = Functions.getDigits(n1);
//        System.out.println(Arrays.toString(v1));
        final int[] v2 = Functions.getDigits(n2);
//        System.out.println(Arrays.toString(v2));
        if (!arePermutations(v1, v2)) {
            return false;
        }
        final int[] v3 = Functions.getDigits(n3);
//        System.out.println(Arrays.toString(v3));
        if (!arePermutations(v2, v3)) {
            return false;
        }
        return true;
    }

    private static boolean arePermutations(int[] v1, int[] v2) {
        if (v1.length != v2.length) {
            return false;
        }
        int count = 0;
        HashMap<Integer, Integer> terms = new HashMap<Integer, Integer>(v1.length);
        for (int i = 0; i < v1.length; i++) {
            terms.put(v1[i], i);
            if (v1[i] == v2[i]) {
                count++;
            }
        }
        if (count == v1.length) {
            return false; // all terms the same
        }
        boolean result = true;
        for (int i = 0; i < v2.length; i++) {
            if (!terms.containsKey(v2[i])) {
                result = false;
                break;
            }
        }
        terms.clear();
        terms = null;
        return result;
    }
}
//
// The arithmetic sequence, 1487, 4817, 8147, in which each of the terms
// increases by 3330, is unusual in two ways: (i) each of the three terms are
// prime, and, (ii) each of the 4-digit numbers are permutations of one another.
//
// There are no arithmetic sequences made up of three 1-, 2-, or 3-digit
// primes, exhibiting this property, but there is one other 4-digit
// increasing sequence.
//
// What 12-digit number do you form by concatenating the three terms in
// this sequence?
//

