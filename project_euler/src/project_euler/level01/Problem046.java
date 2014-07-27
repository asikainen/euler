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
public class Problem046 {

    public static void main(String[] args) {

        final int max = 10000;
        final HashMap<Integer, Integer> primes = new HashMap<Integer, Integer>();
        final SieveOfAtkin sieve = new SieveOfAtkin(max);
        final ArrayList<Integer> list = sieve.run();
        for (int prime : list) {
            primes.put(prime, primes.size());
        }

        int count = 0;
        int result = 0;
        for (int composite = 9, progress = 0; composite < max; composite += 2, progress++) {
            if (!primes.containsKey(composite)) { // composite number
                if (!isGoldbach(list, composite)) {
                    result = composite;
                    break;
                } else {
                    count++;
//                    System.out.println("# composite number " + composite + " is a Goldbach number.");
                }
            }
            if (progress % 1000 == 0) {
                System.out.println("# progress count = " + progress);
            }
        }
        System.out.println("# result = " + result + "; count = " + count);

    }

    private static boolean isGoldbach(ArrayList<Integer> primes, int composite) {
        for (int prime : primes) {
            if (prime >= composite) {
                break;
            }
            final int diff = composite - prime;
            for (int i = 1; i < diff; i++) {
                final int goldbach = prime + 2 * i * i;
                if (goldbach == composite) {
//                    System.out.println("# goldbach: " + composite + " =  " + prime + " + 2*" + i + "^2.");
                    return true;
                }
                if (goldbach > composite) {
                    break;
                }
            }
        }
        return false;
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
// It was proposed by Christian Goldbach that every odd composite number
// can be written as the sum of a prime and twice a square.
//
// 9  = 7  + 2*1^2
// 15 = 7  + 2*2^2
// 21 = 3  + 2*3^2
// 25 = 7  + 2*3^2
// 27 = 19 + 2*2^2
// 33 = 31 + 2*1^2
//
// It turns out that the conjecture was false.
//
// What is the smallest odd composite that cannot be written as the
// sum of a prime and twice a square?
//

