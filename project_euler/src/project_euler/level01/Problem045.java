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
public class Problem045 {

    public static void main(String[] args) throws Exception {
        final HashMap<Long, Integer> triangles = getTriangles(1000000);
        final HashMap<Long, Integer> pentagonals = getPentagonals(1000000);
        final HashMap<Long, Integer> hexagonals = getHexagonals(1000000);
        final long[] keys = new long[triangles.size()];

        int i = 0;
        for (long t : triangles.keySet()) {
            keys[i++] = t;
        }
        Arrays.sort(keys);

        long result = 0;
        for (long key : keys) {
            if (triangles.containsKey(key) && pentagonals.containsKey(key) && hexagonals.containsKey(key)) {
                System.out.println(key + "\t" + triangles.get(key) + "\t" + hexagonals.get(key) + "\t" + pentagonals.get(key));
                result = key;
                if (key > 40755) {
                    break;
                }
            }
        }
        System.out.println("# result = " + result);
    }

    private static HashMap<Long, Integer> getTriangles(int max) throws Exception {
        final HashMap<Long, Integer> map = new HashMap<Long, Integer>(2 * max);
        for (int n = 1; n <= max; n++) {
            final long fn = ((long) n * ((long) n + 1)) / 2;
            if (fn < 0) {
                throw new Exception("triangle out of range " + n + "; " + fn);
            }
            map.put(fn, n);
        }
        return map;
    }

    private static HashMap<Long, Integer> getPentagonals(int max) throws Exception {
        final HashMap<Long, Integer> map = new HashMap<Long, Integer>(2 * max);
        for (int n = 1; n <= max; n++) {
            final long fn = ((long) n * (3 * (long) n - 1)) / 2;
            if (fn < 0) {
                throw new Exception("pentagonal out of range " + n + "; " + fn);
            }
            map.put(fn, n);
        }
        return map;
    }

    private static HashMap<Long, Integer> getHexagonals(int max) throws Exception {
        final HashMap<Long, Integer> map = new HashMap<Long, Integer>(2 * max);
        for (int n = 1; n <= max; n++) {
            final long fn = ((long) n * (2 * (long) n - 1));
            if (fn < 0) {
                throw new Exception("hexagonal out of range " + n + "; " + fn);
            }
            map.put(fn, n);
        }
        return map;
    }
}
//
// Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:
//
// Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
// Pentagonal	 	Pn=n(3n-1)/2	 	1, 5, 12, 22, 35, ...
// Hexagonal	 	Hn=n(2n-1)	 	1, 6, 15, 28, 45, ...
//
// It can be verified that T285 = P165 = H143 = 40755.
//
// Find the next triangle number that is also pentagonal and hexagonal.
//
