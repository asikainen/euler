/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int n = 1000;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println("# answer = " + sum);

//        final int n = 1000;
//        final int[] numbers = new int[n];
//        for (int i = 3; i < n; i += 3) {
//            numbers[i]++;
//        }
//        for (int i = 5; i < n; i += 5) {
//            numbers[i]++;
//        }
//        int answer = 0;
//        for (int i = 0; i < n; i++) {
//            if (numbers[i] > 0) {
//                answer += i;
//            }
//        }
//        System.out.println("answer = " + answer);

    }
}

// If we list all the natural numbers below 10 that are multiples of 3 or 5,
// we get 3, 5, 6 and 9. The sum of these multiples is 23.
//
// Find the sum of all the multiples of 3 or 5 below 1000.
