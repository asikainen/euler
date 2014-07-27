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
public class Problem048 {

    public static void main(String[] args) {

        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++) {
            final String number = String.valueOf(i);
            BigInteger n = new BigInteger(number);
            BigInteger nn = n.pow(i);
            sum = sum.add(nn);
        }
        final int l = sum.toString().length();
        System.out.println("# result = " + sum.toString().substring(l - 10));
    }
}
//
//The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
//
//Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
//
