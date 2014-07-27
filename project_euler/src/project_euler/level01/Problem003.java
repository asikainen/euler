/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * prime factors of 13195 are 5, 7, 13 and 29
 * 
 * 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97.
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem003 {

    private final static long[] primes = new long[1000000];
    private static int np = 0;

    static {
        primes[np++] = 2;
    }

    /**
     * largest prime factor of 600851475143
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        double i = 13195 / 29.;
//        System.out.println(i);
//        i = 13195 / 7.;
//        System.out.println(i);
//        i = 13195 / 13.;
//        System.out.println(i);
//        i = 13195 / 5.;
//        System.out.println(i);
//        System.out.println((5 * 7 * 13 * 29));

        try {
            // test the prime utility
//            for (int i = 2; i < 100; i++) {
//                boolean result = isPrime(i);
//                if (result) {
//                    System.out.print(i + ", ");
//                }
//            }

            final long targetNumber = 600851475143L; // 13195; 

            final long start = getFirstPrime();
            final long end = targetNumber;
            final HashMap<Long, Integer> pfs = new HashMap<Long, Integer>();

            int attempts = 0;
            long number = targetNumber;
            while (number >= start) {
                for (long pf = start; pf <= end; pf++) {
                    if (number < start) {
                        break;
                    }
                    attempts++;
                    if (isPrime(pf)) {
                        if (!isDivisible(number, pf)) {
                            continue;
                        } else {
                            int cnt = 1;
                            if (pfs.containsKey(pf)) {
                                cnt += pfs.get(pf);
                            }
                            pfs.put(pf, cnt);
                            number /= pf;
                            System.out.println((attempts) + "\t" + pf + "\t" + number + "\t" + targetNumber);
                        }
                    }
                }
            }

            System.out.println("# prime factors of " + targetNumber);
            final long[] keys = new long[pfs.size()];
            int idx = 0;
            for (long pf : pfs.keySet()) {
                keys[idx++] = pf;
            }
            Arrays.sort(keys);
            for (long pf : keys) {
                System.out.println(pf + "\t" + pfs.get(pf));
            }
        } catch (Exception ex) {
            Logger.getLogger(Problem003.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean isPrime(final long n) throws Exception {
        if (checkKnownPrimes(n)) {
            return true;
        }
        final long end = (long) Math.sqrt((double) n);
        final long start = getLastPrime();
        boolean result = true;
        if (start >= end) {
            result = checkKnownPrimeDivisions(n, start);
            if (!result) {
                return false;
            }
        }
        result = checkDivisions(start, end, n);
        if (result) {
            setPrime(n);
        }
        return result;
    }

    private static boolean checkDivisions(final long start, final long end, final long n) {
        boolean result = true;
        for (long i = start; i <= end; i++) {
            if(!isDivisible(n, i)) {
                continue;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean checkKnownPrimes(long n) {
        if (n > getLastPrime()) {
            return false;
        } else {
            for (int i = 0; i < np; i++) {
                if (n == primes[i]) {
                    return true;
                }
            }
            return false;
        }
    }

    private static boolean checkKnownPrimeDivisions(long n, long start) {
        for (int i = 0; i < np; i++) {
            final long p = primes[i];
            if(!isDivisible(n, p)) {
                continue;
            } else {
                return false;
            }
//            final double divD = (double) n / (double) p;
//            final double divI = (double) (n / p);
//            if (divD > divI) {
//                continue;
//            } else {
//                return false;
//            }
        }
        return true;
    }

    private static boolean isDivisible(long number, long divisor) {
        final long result = number / divisor;
        return (number == (result * divisor));
    }

    private static long getFirstPrime() {
        return primes[0];
    }

    private static long getLastPrime() {
        return primes[np - 1];
    }

    private static void setPrime(long n) throws Exception {
        if (np >= primes.length) {
            throw new Exception("increase size of primes[] from " + primes.length);
        }
        if (n < getLastPrime()) {
            throw new Exception("primes not set in order " + n + " < " + getLastPrime());
        }
        primes[np++] = n;
    }
}
//
// The prime factors of 13195 are 5, 7, 13 and 29.
//
// What is the largest prime factor of the number 600851475143 ?
//  