    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.util;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class PrimeFinder {

    private final static long[] primes = new long[1000000];
    private static int np = 0;

    static {
        primes[np++] = 2;
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

    public static long getFirstPrime() {
        return primes[0];
    }

    public static long getLastPrime() {
        return primes[np - 1];
    }

    public static int getNumberOfPrimes() {
        return np;
    }

    private static boolean checkDivisions(final long start, final long end, final long n) {
        boolean result = true;
        for (long i = start; i <= end; i++) {
            if (!isDivisible(n, i)) {
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
            if (!isDivisible(n, p)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isDivisible(long number, long divisor) {
        final long result = number / divisor;
        return (number == (result * divisor));
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
