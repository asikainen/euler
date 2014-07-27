/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem036 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        int sum = 0;
        final int first = 0;
        final int last = 1000000;
        for (int i = first; i < last; i++) {
            final String s10 = String.valueOf(i);
            final boolean palindrome1 = isPalindrome(s10);
            final String s2 = Integer.toBinaryString(i);
            final boolean palindrome2 = isPalindrome(s2);
            if (palindrome1 && palindrome2) {
                System.out.println("# base 10: " + s10 + "; " + palindrome1);
                System.out.println("# base 2: " + s2 + "; " + palindrome2);
                sum += i;
            }
        }
        System.out.println("# sum = " + sum);
    }

    private static boolean isPalindrome(String s) {
        if (s.startsWith("0")) {
            return false;
        }
        final char[] chars = s.toCharArray();
        final int l = chars.length;
        final int l2 = l / 2;
        boolean palindrome = true;
        for (int i = 0; i < l2; i++) {
            if (chars[i] != chars[l - i - 1]) {
                palindrome = false;
                break;
            }
        }
        return palindrome;
    }
}
// The decimal number, 585 = 1001001001_{2} (binary), is palindromic in both bases.
//
// Find the sum of all numbers, less than one million, which are palindromic
// in base 10 and base 2.
//
// (Please note that the palindromic number, in either base, may not
// include leading zeros.)

