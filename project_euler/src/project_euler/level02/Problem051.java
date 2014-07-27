/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import project_euler.util.Functions;
import project_euler.util.SieveOfAtkin;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem051 {

    public static void main(String[] args) {
        final int max = 1000000;
        final HashMap<Integer, Integer> primes = new HashMap<Integer, Integer>();
        final SieveOfAtkin sieve = new SieveOfAtkin(max);
        final ArrayList<Integer> list = sieve.run();
        for (int prime : list) {
            primes.put(prime, primes.size());
        }

        list.clear();
        final int[] digits = Functions.getDigits(56113);
        final DigitSwapper swapper = new DigitSwapper(2, digits);
        System.out.println(Arrays.toString(digits));
        int[] swapped = null;
        while ((swapped = swapper.next()) != null) {
            if (swapped[0] == 5 && swapped[1] == 6 && swapped[4] == 3) {
//                System.out.println(Arrays.toString(swapped));
                final int number = Functions.getInt(swapped);
                if (primes.containsKey(number)) {
                    list.add(number);
//                    System.out.println("# prime " + number);
                }
//            System.out.println(Arrays.toString(swapped));
            }
        }

        for (int item : list) {
            System.out.println(item);
        }
    }

    private static class DigitSwapper {

        private final int[] digits;
        private final int[] swapped;
        private final int max;
        private final int n;
        private int digit;
        private int idx;

        public DigitSwapper(int n, int[] digits) {
            this.digits = new int[digits.length];
            System.arraycopy(digits, 0, this.digits, 0, digits.length);
            this.swapped = new int[digits.length];
            System.arraycopy(digits, 0, this.swapped, 0, digits.length);
            this.n = n;
            this.max = (digits.length - n);
            this.digit = 0;
            this.idx = 0;
        }

        public final int[] next() {
            if (idx == max && digit == 10) {
                return null;
            } else if (digit == 10) {
                initialize();
            }
            for (int i = idx; i < (idx + n); i++) {
                swapped[i] = digit;
            }
            digit++;
            return swapped;
        }

        private void initialize() {
            System.arraycopy(digits, 0, swapped, 0, digits.length);
            digit = 0;
            idx++;
        }
    }
}
//
// By replacing the 1st digit of *3, it turns out that six of the nine
// possible values: 13, 23, 43, 53, 73, and 83, are all prime.
//
// By replacing the 3rd and 4th digits of 56**3 with the same digit,
// this 5-digit number is the first example having seven primes among the
// ten generated numbers, yielding the family:
//
// 56003, 56113, 56333, 56443, 56663, 56773, and 56993.
//
// Consequently 56003, being the first member of this family, is the
// smallest prime with this property.
//
// Find the smallest prime which, by replacing part of the number
// (not necessarily adjacent digits) with the same digit, is part of an
// eight prime value family.
//

