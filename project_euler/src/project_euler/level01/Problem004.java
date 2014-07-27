/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem004 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int max = 999;
        final int min = 99;
        int answer = -1;
        int term1 = -1;
        int term2 = -1;
        for (int i = max; i > min; i--) {
            for (int j = max; j > min; j--) {
                final int k = i * j;
                if (isPalindrome(k)) {
                    if (k > answer) {
                        term1 = i;
                        term2 = j;
                        answer = k;
                        System.out.println("# term1 = " + term1 + "; term2 = " + term2 + "; answer = " + answer);
                    }
                }
            }
        }
        System.out.println("# answer = " + answer);
    }

    public static boolean isPalindrome(int n) {
        if (n < 0) {
            return false;
        }
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        final int l = chars.length;
        final int l2 = l / 2;
        for (int i = 0; i < l2; i++) {
            int j = (l - 1 - i);
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }
}
//
// palindromic number reads the same both ways. The largest palindrome made
// from the product of two 2-digit numbers is 9009 = 91  99.
//
// Find the largest palindrome made from the product of two 3-digit numbers.
//