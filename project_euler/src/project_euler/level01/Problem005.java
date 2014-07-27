/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem005 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int maxDivisor = 20;
        int attempts = 0;
        int answer = -1;
        int number = 2520;
        while (answer < 0) {
            attempts++;
            boolean done = true;
            for (int divisor = maxDivisor; divisor > 0; divisor--) {
                if (!isDivisible(number, divisor)) {
                    done = false;
                    break;
                }
            }
            if (done) {
                answer = number;
            } else {
                number += 20;
            }
        }

//        number = 232792560;
        for (int divisor = maxDivisor; divisor > 0; divisor--) {
            System.out.println(divisor + "\t" + number + "\t" + isDivisible(number, divisor));
        }
        System.out.println("# answer = " + answer + "; attempts = " + attempts);
    }

    public static boolean isDivisible(int number, int divisor) {
        final int result = number / divisor;
        return (number == (result * divisor));
    }
}
//
// The sum
// of the squares of the first ten natural numbers is,
//
// 1 to the power of (2) + 2 to the power of (2) + ... + 10 to the power
// of (2) = 385
//
// The square of the sum of the first ten natural numbers is,
//
// (1 + 2 + ... + 10) to the power of (2) = 55 to the power of (2) = 3025
// Hence the difference between the sum of the squares of the first ten
// natural numbers and the square of the sum is 3025  385 = 2640.
//
// Find the difference between the sum of the squares of the first
// one hundred natural numbers and the square of the sum.
//