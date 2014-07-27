/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.math.BigInteger;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem016 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int n = 1000;
        final BigInteger two = new BigInteger("2");
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            result = result.multiply(two);
        }
        System.out.println("# " + two + " to the power of " + n + " = " + result);
        final String digits = result.toString();
        int sum = 0;
        for (int i = 0; i < digits.length(); i++) {
            String digit = digits.substring(i, i + 1);
            int number = Integer.parseInt(digit);
            sum += number;
        }
        System.out.println("# sum of digits = " + sum);
    }
}
//
//215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
//
//What is the sum of the digits of the number 21000?
//