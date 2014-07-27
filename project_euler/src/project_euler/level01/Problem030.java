/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem030 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        final int power = 5;
        final int maxnumber = (int) (power * java.lang.Math.pow((double) 9, (double) power));

        int count = 0;
        int total = 0;
        for (int number = 2; number < maxnumber; number++) {
            final int sum = sumOfDigitsToPower(number, power);
            if (sum == number) {
                count++;
                total += number;
                System.out.println(count + "\t" + number + "\t" + power + "\t" + sum);
            }
        }
        System.out.println("# count = " + count + "; total = " + total);
    }

    private static int sumOfDigitsToPower(int number, int power) {
        int sum = 0;
        final String digits = String.valueOf(number);
        for (int i = 0; i < digits.length(); i++) {
            final int digit = Integer.parseInt(digits.substring(i, i + 1));
            final int term = (int) java.lang.Math.pow((double) digit, (double) power);
            sum += term;
        }
        return sum;
    }
}
// Surprisingly there are only three numbers that can be written as the
// sum of fourth powers of their digits:
//
// 1634 = 1^4 + 6^4 + 3^4 + 4^4
// 8208 = 8^4 + 2^4 + 0^4 + 8^4
// 9474 = 9^4 + 4^4 + 7^4 + 4^4
//
// As 1 = 1^4 is not a sum it is not included.
//
// The sum of these numbers is 1634 + 8208 + 9474 = 19316.
//
// Find the sum of all the numbers that can be written as the sum of fifth
// powers of their digits.
