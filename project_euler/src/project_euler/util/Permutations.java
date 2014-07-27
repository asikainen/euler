/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.util;

import java.util.Arrays;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Permutations {

    private static int level = -1;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        final int n = 4;
        final int[] v = new int[n];
        visit(v, n, 0);
    }

    private static void visit(int[] v, int n, int k) {

        level = level + 1;
        v[k] = level;
        if (level == n) {
            System.out.println(Arrays.toString(v));
        } else {
            for (int i = 0; i < n; i++) {
                if (v[i] == 0) {
                    visit(v, n, i);
                }
            }
        }
        level = level - 1;
        v[k] = 0;
    }
}
