/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.math.BigInteger;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem015 {

    private final static int N = 2;
    private static long steps = 0;
    private static long routes = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final int n = 20;
        final BigInteger b1 = nOutOfM(String.valueOf(n), String.valueOf(2 * n));
        final BigInteger b2 = factorial(String.valueOf(n));
        final BigInteger result = b1.divide(b2);
        final int[] counters = new int[N];


//        walk(0, 0);
//        System.out.println("# routes = " + routes + "; steps = " + steps);
    }

    private static BigInteger factorial(String sn) {
        BigInteger f = BigInteger.ONE;
        final int n = Integer.parseInt(sn);
        for (int i = 1; i <= (int) n; i++) {
            BigInteger b = new BigInteger(String.valueOf(i));
            f = f.multiply(b);
        }
        return f;
    }

    private static BigInteger nOutOfM(String sn, String sm) {
        BigInteger result = BigInteger.ONE;
        int n = Integer.parseInt(sn);
        int m = Integer.parseInt(sm);
        for (int i = 0; i < n; i++) {
            BigInteger b = new BigInteger(String.valueOf((m - i)));
            result = result.multiply(b);
        }
        return result;
    }

    private static int walk(int x, int y) {

        // check corner
        steps++;
//        System.out.println(x + "\t" + y + "\t" + steps + "\t" + routes);
        if (x == N && y == N) {
//            System.out.println("---");
            routes++;
            if (routes % 10000000 == 0) {
                System.out.println("# routes = " + routes + "; steps = " + steps);
            }
            return 1;
        }

        // step to x+1
        if (x < N) {
            walk(x + 1, y);
        }

        // step to y+1
        if (y < N) {
            walk(x, y + 1);
        }

        // not in the corner
        return 0;
    }

    private static void forLoop(int n) {

        for (int i = 0; i < n; i++) {
        }
    }
}
//
//Starting in
//the top left corner of a 22 grid, there are 6 routes (without backtracking)
//to the bottom right corner.
//
//
//How many routes are there through a 2020 grid?
