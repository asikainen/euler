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
public class Problem021 {

    public static void main(String[] args) {
        final int n = 10000;
        final int n2 = n / 2;
        final int[] d = new int[n + 1];
        final ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= n2; i++) {
            int j = i;
            while (j + i <= n) {
                j += i;
                d[j] += i;
                lists.get(j).add(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            final ArrayList<Integer> list = lists.get(i);
            final int sze = list.size();
            int sum = 0;
            System.out.print(i + ": ");
            for (int j = 0; j < sze; j++) {
                final int div = list.get(j);
                sum += div;
                System.out.print(div);
                if (j < sze - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("; sum1 =" + sum);
            System.out.print("; sum2 = " + d[i]);
            if (d[i] != sum) {
                System.err.println("# discrepancy at i = " + i);
            }
            if (sze < 2) {
                System.out.print("; prime");
            }
            System.out.println();
        }

        int amicables = 0;
        for (int i = 1; i <= n; i++) {
            final int di = d[i];
            if (di <= n && di != i && d[di] == i) {
                System.out.println("Amicable pair " + i + "\t" + d[i]);
                amicables += di;
            }
        }
        System.out.println("# sum of amicable numbers = " + amicables);
    }
}
// Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
// If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair and each of a and b are called amicable numbers.
//
// For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
// The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
//
// Evaluate the sum of all the amicable numbers under 10000.

