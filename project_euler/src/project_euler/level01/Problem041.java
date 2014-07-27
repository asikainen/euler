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
public class Problem041 {

    private final static int min = 123456789;
    private final static int max = 987654321;
    private final static HashMap<Integer, Integer> primes = new HashMap<Integer, Integer>();
    private static int maxAtkinPrime = 0;
    private static int lpdPrime = 0;
    private static int level = -1;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        final SieveOfAtkin sieve = new SieveOfAtkin(1000000);
        final ArrayList<Integer> list = sieve.run();
        for (int prime : list) {
            primes.put(prime, primes.size());
            if (prime > maxAtkinPrime) {
                maxAtkinPrime = prime;
            }
        }

        for (int n = 2; n < 10; n++) {
            final int[] v = new int[n];
            visit(v, n, 0);
        }
        System.out.println("# largest pandigital prime = " + lpdPrime);
    }

    private static boolean checkPrime(int[] v) {
        final int n = digitsToInt(v);
        if (n <= maxAtkinPrime) {
            if (primes.containsKey(n)) {
                if (n > lpdPrime) {
                    lpdPrime = n;
                    return true;
                }
            }
        } else {
            if (isPrime(n)) {
                if (n > lpdPrime) {
                    lpdPrime = n;
                    return true;
                }
            }
        }
        return false;
    }

    private static int digitsToInt(int[] v) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < v.length; i++) {
            sb.append(v[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    private static void visit(int[] v, int n, int k) {

        level = level + 1;
        v[k] = level;

        if (level == n) {
            if (checkPrime(v)) {
                System.out.println("# n = " + n + "; lpdPrime = " + lpdPrime);
            }
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

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        } else if (number == 2) {
            return true;
        } else if (number == 3) {
            return true;
        } else if (number == 5) {
            return true;
        }
        final int start = 2;
        final int end = (int) Math.sqrt((double) number);
        final boolean result = isDivisible(number, start, end);
        return result;
    }

    private static boolean isDivisible(final int number, final int firstDivisor, final int lastDivisor) {
        boolean result = true;
        for (int divisor = firstDivisor; divisor <= lastDivisor; divisor++) {
            if (!isDivisible(number, divisor)) {
                continue;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean isDivisible(final int number, final int divisor) {
        final int result = number / divisor;
        return (number == (result * divisor));
    }
}
//
// We shall say that an n-digit number is pandigital if it makes use of
// all the digits 1 to n exactly once. For example, 2143 is a 4-digit
// pandigital and is also prime.
//
// What is the largest n-digit pandigital prime that exists?
//

