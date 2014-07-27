/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem040 {

    public static void main(String[] args) {

        final int[] subscripts =
                new int[]{1, 10, 100, 1000, 10000, 100000, 1000000};
        final int last = subscripts[subscripts.length - 1];

        String s = null;
        long p = 1;
        int ls = 0;
        int j = 0;
        int l = 0;
        for (int i = 1; i < 1000000; i++) {
            s = String.valueOf(i);
//            System.out.print(s);
            ls = s.length();
            l += ls;
            if (l >= subscripts[j]) {
                final int n = ls - (l - subscripts[j]) - 1;
                final int d = Integer.parseInt(s.substring(n, n + 1));
                p *= (long) d;
//                System.out.println("\n# d = " + d + "; s = " + subscripts[j]);
                j++;
            }
            if (l > last) {
                break;
            }
        }
        System.out.println("# p = " + p);
    }
}
//
// An irrational decimal fraction is created by concatenating the positive integers:
//
// 0.123456789101112131415161718192021...
//
// It can be seen that the 12th digit of the fractional
// part is 1.
//
// If d (n) represents the n (th) digit of the
// fractional part, find the value of the following expression.
//
// d (1) x d (10) x d (100) x d (1000) x d (10000) x d (100000) x d (1000000)
//
