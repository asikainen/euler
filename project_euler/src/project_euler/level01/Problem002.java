/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem002 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int n = 4000000;
        int sum = 0;
        int prev = 1;
        int curr = 1;
        int next = 1;
        System.out.println(next + "\t" + sum);
        while (next < n) {
            curr = next;
            next = prev + curr;
            if (next % 2 == 0) {
                if (next < n) {
                    sum += next;
                }
            }
            System.out.println(next + "\t" + sum);
            prev = curr;
        }
        System.out.println("# answer = " + sum);
    }
}
//
// Each new term in the Fibonacci sequence is generated by adding the previous
// two terms. By starting with 1 and 2, the first 10 terms will be:
//
// 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
//
// By considering the terms in the Fibonacci sequence whose values do not
// exceed four million, find the sum of the even-valued terms
//