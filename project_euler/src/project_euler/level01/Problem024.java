/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.Arrays;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem024 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        final int n = 10;
        final int target = 1000000;
        final int[] digits = computeTargetPermutation(n, target);
        System.out.print("# rank = " + target);
        System.out.print("; permutation = ");
        for (int i = 0; i < n; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();

//        final int maxTarget = factorial(n);
//        final String[] permutations = new String[maxTarget];
//        for (int target = 1; target <= maxTarget; target++) {
//            final int[] digits = computeTargetPermutation(n, target);
//            System.out.print("# rank = " + target);
//            System.out.print("; permutation = ");
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < n; i++) {
//                sb.append(digits[i]);
//                System.out.print(digits[i]);
//            }
//            permutations[target - 1] = sb.toString();
//            System.out.println();
//        }
//        final String[] sorted = new String[maxTarget];
//        for (int target = 0; target < maxTarget; target++) {
//            sorted[target] = permutations[target];
//        }
//        Arrays.sort(sorted);
//        for (int target = 0; target < maxTarget; target++) {
//            if (!sorted[target].equals(permutations[target])) {
//                System.out.println("# sorting error at " + target);
//            }
//        }
    }

    private static int[] computeTargetPermutation(int n, int target) {

        final int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        int rank = 1;
        int offset = 0;
        int offset1 = 0;
        int offset2 = offset1 + 1;
        while (rank < target) {
            // number of permutations with the digits up to 'offset' fixed
            final int permutations = factorial(n - (offset1 + 1));
            if (rank + permutations <= target) {
                rank += permutations;
                swap(indexes, offset1, offset2);
                offset2++;
            } else {
                offset1++;
                offset2 = offset1 + 1;
            }

            // cycle back
            if (offset2 == n) {
                offset2 = offset + 1;
            }

            // all digits up to offset are fixed already
            offset++;
        }
        return indexes;
    }

    private static int factorial(final int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    private static void swap(int[] array, int offset1, int offset2) {
        if (offset1 < 0 || offset1 >= array.length || offset2 < 0 || offset2 >= array.length) {
            System.err.println("out of range; " + array.length + "; " + offset1 + "; " + offset2);
            return;
        }
        final int tmp = array[offset1];
        array[offset1] = array[offset2];
        array[offset2] = tmp;
    }

    private static int[] computeTargetPermutation_Old(int n, int target) {

        final int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        int rank = 1;
        int offset = 0;
        int offset1 = 0;
        int offset2 = offset1 + 1;
        while (rank < target) {
            // number of permutations with the digits up to 'offset' fixed
            final int permutations = factorial(n - (offset1 + 1));
            if (rank + permutations <= target) {
                rank += permutations;
                swap(indexes, offset1, offset2);
                offset2++;
//                if (offset2 == n) {
//                    offset1++;
//                    offset2 = offset1 == (n - 1) ? (offset1 - 1) : (offset1 + 1);
//                }
//                System.out.println("# rank = " + rank);
//                System.out.print("# permutation = ");
//                for (int i = 0; i < n; i++) {
//                    System.out.print(indexes[i]);
//                }
            } else {
                offset1++;
//                offset2++;
//                if (offset2 == n) {
//                    offset2 = offset1 - 1;
//                }
            }
//            if (offset1 == n - 1 && offset2 == n) {
//                System.out.println("# hitting " + n);
//                System.out.print("# rank = " + target);
//                System.out.print("; permutation = ");
//                for (int i = 0; i < n; i++) {
//                    System.out.print(indexes[i]);
//                }
//                System.out.println();
//            }

            // all digits up to offset are fixed already
            offset++;
        }
        return indexes;
    }
}
//
// A permutation is an ordered arrangement of objects. For example, 3124 is one
// possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
// are listed numerically or alphabetically, we call it lexicographic order.
// The lexicographic permutations of 0, 1 and 2 are:
//
// 012   021   102   120   201   210
//
// What is the millionth lexicographic permutation of the
// digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

