/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.util;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Functions {

    public static int factorial(int n) throws Exception {
        if (n < 0 || n > 16) {
            throw new Exception("factorial(int): argument out of range " + n + "; min = 0; max = 16;");
        } else if (n == 0) {
            return 1;
        }
        int f = n;
        while ((--n) > 0) {
            f *= n;
        }
        return f;
    }

    public static long factorial(long n) throws Exception {
        if (n < 0 || n > 20) {
            throw new Exception("factorial(long): argument out of range " + n + "; min = 0; max = 20;");
        } else if (n == 0) {
            return 1L;
        }
        long f = n;
        while ((--n) > 0) {
            f *= n;
        }
        return f;
    }

    public static int[] getDigits(int number) {
        final String str = String.valueOf(number);
        final int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            final int digit = Integer.parseInt(str.substring(i, i + 1));
            digits[i] = digit;
        }
        return digits;
    }

    public static int getInt(int[] digits) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    public static int getInt(int[] digits, int start, int end) {
        final StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(digits[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    public static long fibonacci(final long n) {
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

    public static String divide(final int num, final int denum, int accuracy) {
        final StringBuilder sb = new StringBuilder();
        int result = num / denum;
        sb.append(result);
        sb.append(".");
        int decimals = 0;
        int rem = num - (result * denum);
        while (decimals < accuracy) {
            rem *= 10;
            result = rem / denum;
            rem %= denum;
            sb.append(result);
            if (rem == 0) {
                break;
            }
            decimals++;
        }
        return sb.toString();
    }
}
