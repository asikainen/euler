/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import project_euler.util.SieveOfAtkin;
import project_euler.util.Functions;
import project_euler.util.Rotator;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem035 {

    private final static HashMap<Integer, Integer> primes = new HashMap<Integer, Integer>();
    private static int level = -1;

    public static void main(String[] args) {
        try {

            final SieveOfAtkin sieve = new SieveOfAtkin(1000000);
            final ArrayList<Integer> list = sieve.run();
            for (int prime : list) {
//                System.out.println(prime);
                primes.put(prime, primes.size());
            }

            int total = 0;
            for (int prime : list) {
//            for (int prime : new int[]{9377}) {
                final int[] digits = Functions.getDigits(prime);
                final int[] v = new int[digits.length];
//                final int target = Functions.factorial(digits.length);
//                final int found = visit(v, digits, digits.length, 0);
                Rotator rotator = new Rotator(digits);
                int[] rotation = null;
                boolean found = true;
                while ((rotation = rotator.next()) != null) {
                    final int p = Functions.getInt(rotation);
                    if (!primes.containsKey(p)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    total++;
                    System.out.println("# special prime " + prime);
                }
            }
            System.out.println("# count = " + total);
        } catch (Exception ex) {
            Logger.getLogger(Problem035.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static int visit(int[] v, int[] a, int n, int k) {

        level = level + 1;
        v[k] = level;

        int result = 0;
        if (level == n) {
            final int[] d = new int[n];
            for (int i = 0; i < n; i++) {
                d[i] = a[v[i] - 1];
            }
            final int p = Functions.getInt(d);
            if (primes.containsKey(p)) {
                System.out.println("# checked prime " + p + " OK!");
                result = 1;
            } else {
                System.out.println("# checked prime " + p + " NOT!");
                result = 0;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (v[i] == 0) {
                    result += visit(v, a, n, i);
                }
            }
        }

        level = level - 1;
        v[k] = 0;
        return result;
    }
}
// The number, 197, is called a circular prime because all rotations
// of the digits: 197, 971, and 719, are themselves prime.
//
// There are thirteen such primes below 100:
//
// 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
//
// How many circular primes are there below one million?

