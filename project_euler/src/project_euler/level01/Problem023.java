/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.ArrayList;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem023 {

    public static void main(String[] args) {
        ArrayList<Integer> abundants = new ArrayList<Integer>();
        final int n = 28123;
        final int n2 = n / 2;
        final int[] d = new int[n + 1];
        for (int i = 1; i <= n2; i++) {
            int j = i;
            while (j + i <= n) {
                j += i;
                d[j] += i;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (d[i] > i) {
                abundants.add(i);
//                System.out.println(i + "\t" + d[i]);
            }
        }

        final int[] ints = new int[n + 1];
        for (int i = 0; i < abundants.size(); i++) {
            final int ab1 = abundants.get(i);
            for (int j = 0; j < abundants.size(); j++) {
                final int ab2 = abundants.get(j);
                if (ab1 + ab2 <= n) {
                    ints[ab1 + ab2]++;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i <= n; i++) {
            if (ints[i] == 0) {
//                System.out.println(i);
                sum += i;
            }
        }

        System.out.println("# sum = " + sum);
    }
}
//
// A perfect number is a number for which the sum of its proper divisors is
// exactly equal to the number. For example, the sum of the proper divisors
// of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
//
// A number n is called deficient if the sum of its proper divisors is less than
// n and it is called abundant if this sum exceeds n.
//
// As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
// number that can be written as the sum of two abundant numbers is 24. By
// mathematical analysis, it can be shown that all integers greater than 28123
// can be written as the sum of two abundant numbers. However, this upper limit
// cannot be reduced any further by analysis even though it is known that
// the greatest number that cannot be expressed as the sum of two abundant
// numbers is less than this limit.
//
// Find the sum of all the positive integers which cannot be written as the
// sum of two abundant numbers.
//

