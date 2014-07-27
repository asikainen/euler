/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.util;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class PrimeChecker {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            System.out.println(i + "\t" + (i % 2) + "\t" + (i & 0x01));
            System.out.println(i + "\t" + isPrime(i));
        }
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
        } else if ((number & 0x01) == 0) {
            return false;
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
