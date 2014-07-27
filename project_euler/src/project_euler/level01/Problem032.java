/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem032 {

    private final static int min = 123456789;
    private final static int max = 987654321;
    private final static HashMap<Integer, Integer> pds = new HashMap<Integer, Integer>();
    private static int np = 0;
    private static int level = -1;

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        final int n = 9;
        final int[] v = new int[n];
        visit(v, n, 0);
        int sum = 0;
        for (int k : pds.keySet()) {
            sum += k;
        }
        System.out.println("# number of pandigital numbers = " + pds.size() + "; sum = " + sum);
    }

    private static void visit(int[] v, int n, int k) {

        level = level + 1;
        v[k] = level;

        if (level == n) {
            np++;
//            System.out.println(np + "; " + Arrays.toString(v));
            checkPanDigital(v, pds);
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

    private static void checkPanDigital(int[] indexes, HashMap<Integer, Integer> products) {
        for (int split1 = 1; split1 < indexes.length - 1; split1++) {
            for (int split2 = split1 + 1; split2 < indexes.length; split2++) {
                StringBuilder sb1 = new StringBuilder();
                for (int i = 0; i < split1; i++) {
                    sb1.append(indexes[i]);
                }
                StringBuilder sb2 = new StringBuilder();
                for (int j = split1; j < split2; j++) {
                    sb2.append(indexes[j]);
                }
                StringBuilder sb3 = new StringBuilder();
                for (int k = split2; k < indexes.length; k++) {
                    sb3.append(indexes[k]);
                }
                final int i = Integer.parseInt(sb1.toString());
                final int j = Integer.parseInt(sb2.toString());
                final int k = Integer.parseInt(sb3.toString());
                if ((i * j) == k) {
                    if (!products.containsKey(k)) {
                        System.out.println(Arrays.toString(new int[]{i, j, k}));
                        products.put(k, products.size());
                    }
                }
            }
        }
    }

    private static void run() {

        final HashMap<Integer, Integer> products = new HashMap<Integer, Integer>();
        for (int i = 1; i <= max; i++) {
            final int l1 = (int) java.lang.Math.log10((double) i) + 1;
            for (int j = min / i; j <= max; j++) {
                final int l2 = (int) java.lang.Math.log10((double) j) + 1;
                final int k = i * j;
                final int l3 = (int) java.lang.Math.log10((double) k) + 1;
                if (l1 + l2 + l3 != 9) {
                    continue;
                }
                if (isPanDigital(i, j, k, min, max)) {
                    if (!products.containsKey(k)) {
                        products.put(k, products.size());
                    }
                }
            }
        }
        int sum = 0;
        for (int k : products.keySet()) {
            sum += products.get(k);
        }
        System.out.println("# number of pandigital numbers = " + products.size() + "; sum = " + sum);
    }

    private static boolean isPanDigital(int i, int j, int k, int min, int max) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(j);
        sb.append(k);
        if (sb.length() != 9) {
            return false;
        }
        int num = Integer.parseInt(sb.toString());
        if (num < min || num > max) {
            return false;
        }
        final int[] dst = new int[10];
        for (int n = 0; n < sb.length(); n++) {
            final String s = sb.substring(n, n + 1);
            int m = Integer.parseInt(s);
            dst[m]++;
            if (dst[m] > 1) {
                return false;
            }
        }
        return true;
    }

    private static int[] getPermutations(int n) {
        final int target = factorial(n);
        final int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i + 1;
        }
        System.out.println(Arrays.toString(indexes));

        final HashMap<Integer, Integer> products = new HashMap<Integer, Integer>();
//        checkPanDigital(indexes, products);

        int index = 1;
        int offset = 0;
        int offset1 = 0;
        int offset2 = offset1 + 1;
        while (index < target) {
            index++;
            swap(indexes, offset1, offset2);
            System.out.println(Arrays.toString(indexes));
//                checkPanDigital(indexes, products);

            // cycle back
            offset2++;
            if (offset2 == n) {
                offset++;
                offset1 = offset;
                offset2 = 0;
            }
        }

        // compute the sum of (unique) pandigital numbers
        int sum = 0;
        for (int k : products.keySet()) {
            sum += products.get(k);
        }
        System.out.println("# number of pandigital numbers = " + products.size() + "; sum = " + sum);
        return indexes;
    }

    private static int[] computePermutations(int n) {
//        final int target = factorial(n);
        final int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
            //indexes[i] = i + 1;
        }

        final int total = computePermutations(indexes, 0, n);
        System.out.println("# " + np + "; total = " + total);

        return indexes;
    }

    private static int computePermutations(int[] indexes, int offset, int n) {
        if (offset == n) {
            return 0;
        }
        int count = 0;
        int num = factorial((n - offset - 1));
        //for (int off = 0; off < n - 1; off++) {
        int off = 0;
        for (int i = 0; i < num; i++) {
            count++;
            np++;
            if (offset == n - 1) {
                swap(indexes, off, 0);
                off = 0;
            } else {
                swap(indexes, off, off + 1);
            }
            off++;
            System.out.println("# " + np + "; permutation = " + Arrays.toString(indexes));
        }
        count += computePermutations(indexes, offset + 1, n);
        return count;
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

    private static void checkSplits(int[] indexes) {
        int splits = 0;
        for (int split1 = 1; split1 < indexes.length - 1; split1++) {
            for (int split2 = split1 + 1; split2 < indexes.length; split2++) {
                splits++;
                System.out.print("# split (" + split1 + ", " + split2 + "):");
                for (int i = 0; i < split1; i++) {
                    System.out.print(indexes[i]);
                }
                System.out.print(" - ");
                for (int j = split1; j < split2; j++) {
                    System.out.print(indexes[j]);
                }
                System.out.print(" - ");
                for (int k = split2; k < indexes.length; k++) {
                    System.out.print(indexes[k]);
                }
            }
        }
        System.out.println("# number of splits = " + splits);
    }
}
// We shall say that an n-digit number is pandigital if it makes use of all
// the digits 1 to n exactly once; for example, the 5-digit number,
// 15234, is 1 through 5 pandigital.
//
// The product 7254 is unusual, as the identity, 39 x 186 = 7254, containing
// multiplicand, multiplier, and product is 1 through 9 pandigital.
//
// Find the sum of all products whose multiplicand/multiplier/product identity
// can be written as a 1 through 9 pandigital.
//
// HINT: Some products can be obtained in more than one way so be sure to
// only include it once in your sum.

