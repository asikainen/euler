/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.ArrayList;
import java.util.HashMap;
import project_euler.util.Functions;
import project_euler.util.SieveOfAtkin;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem037 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        final SieveOfAtkin sieve = new SieveOfAtkin(1000000);
        final ArrayList<Integer> list = sieve.run();
        final HashMap<Integer, Integer> primes = new HashMap<Integer, Integer>();
        for (int prime : list) {
            primes.put(prime, primes.size());
        }
        int count = 0;
        int sum = 0;
        for (int prime : list) {
//        for (int prime : new int[]{3797}) {
            if (isTruncatable(prime, primes)) {
                System.out.println(prime);
                sum += prime;
                count++;
            }
        }
        System.out.println("# sum = " + sum + "; count = " + count);
    }

    private static boolean isTruncatable(int prime, HashMap<Integer, Integer> primes) {
        if (prime <= 7) {
            return false;
        }
        if (!primes.containsKey(prime)) {
            return false;
        }
        final int[] digits = Functions.getDigits(prime);
        for (int offset = 1; offset < digits.length; offset++) {
            final int p = Functions.getInt(digits, offset, digits.length);
            if (!primes.containsKey(p)) {
                return false;
            }
        }
        for (int offset = digits.length - 1; offset > 0; offset--) {
            final int p = Functions.getInt(digits, 0, offset);
            if (!primes.containsKey(p)) {
                return false;
            }
        }
        return true;
    }
}
//
// The number 3797 has an interesting property. Being prime itself, it is
// possible to continuously remove digits from left to right, and remain
// prime at each stage: 3797, 797, 97, and 7. Similarly we can work from
// right to left: 3797, 379, 37, and 3.
//
// Find the sum of the only eleven primes that are both truncatable from
// left to right and right to left.
//
// NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes
//

