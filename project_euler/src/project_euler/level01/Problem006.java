/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem006 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int max = 100;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i <= max; i++) {
            sum1 += i * i;
            sum2 += i;
        }
        sum2 *= sum2;
        final int answer = sum2 - sum1;
        System.out.println("# answer = " + answer);

    }
}
//
//The sum of the squares of the first ten natural numbers is,
//
//12 + 22 + ... + 102 = 385
//The square of the sum of the first ten natural numbers is,
//
//(1 + 2 + ... + 10)2 = 552 = 3025
//Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025  385 = 2640.
//
//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
//
