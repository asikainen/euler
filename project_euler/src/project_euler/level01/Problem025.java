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
public class Problem025 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
//        final long n = 49;
//        for (long i = 1; i <= n; i++) {
//            System.out.println("# f(" + i + ") = " + fibonacci(i));
//        }
        // # 49th Fibonacci number = 7,778,742,049 (Wikipedia)
        // # f(49)                 = 7,778,742,049

        final int length = 1000;
        long n = 3;
        BigInteger fn = BigInteger.ZERO;
        BigInteger fn1 = BigInteger.ONE;
        BigInteger fn2 = BigInteger.ONE;
        while (true) {
            fn = fn1.add(fn2);
            final String s = fn.toString();
            if (s.length() >= length) {
                break;
            }
            fn2 = fn1;
            fn1 = fn;
            n++;
        }
        System.out.println("# n = " + n + "; length(f(" + n + ")) = " + fn.toString().length() + "; f(" + n + ") = " + fn.toString());
    }

    private static long fibonacci(final long n) {
        if (n < 3) {
            return 1;
        }
        long f = 0;
        long fn1 = 1;
        long fn2 = 1;
        for (long i = 3; i <= n; i++) {
            f = fn1 + fn2;
            fn2 = fn1;
            fn1 = f;
        }

        return f;
    }
}
// The Fibonacci sequence is defined by the recurrence relation:
//
// F(n) = F(n-1) + F(n-2), where F(1) = 1 and F(2) = 1.
// Hence the first 12 terms will be:
//
// F1 = 1
// F2 = 1
// F3 = 2
// F4 = 3
// F5 = 5
// F6 = 8
// F7 = 13
// F8 = 21
// F9 = 34
// F10 = 55
// F11 = 89
// F12 = 144
// The 12th term, F12, is the first term to contain three digits.
//
// What is the first term in the Fibonacci sequence to contain 1000 digits?

