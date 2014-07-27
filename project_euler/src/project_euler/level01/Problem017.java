/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.HashMap;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem017 {

    private final static HashMap<Integer, String> numbersToWords = new HashMap<Integer, String>();

    static {
//        numbersToWords.put(0, "zero");
        numbersToWords.put(1, "one");
        numbersToWords.put(2, "two");
        numbersToWords.put(3, "three");
        numbersToWords.put(4, "four");
        numbersToWords.put(5, "five");
        numbersToWords.put(6, "six");
        numbersToWords.put(7, "seven");
        numbersToWords.put(8, "eight");
        numbersToWords.put(9, "nine");
        numbersToWords.put(10, "ten");
        numbersToWords.put(11, "eleven");
        numbersToWords.put(12, "twelve");
        numbersToWords.put(13, "thirteen");
        numbersToWords.put(14, "fourteen");
        numbersToWords.put(15, "fifteen");
        numbersToWords.put(16, "sixteen");
        numbersToWords.put(17, "seventeen");
        numbersToWords.put(18, "eighteen");
        numbersToWords.put(19, "nineteen");
        numbersToWords.put(20, "twenty");
        numbersToWords.put(30, "thirty");
        numbersToWords.put(40, "forty");
        numbersToWords.put(50, "fifty");
        numbersToWords.put(60, "sixty");
        numbersToWords.put(70, "seventy");
        numbersToWords.put(80, "eighty");
        numbersToWords.put(90, "ninety");
        numbersToWords.put(100, "hundred");
        numbersToWords.put(1000, "thousand");
        for (int key : numbersToWords.keySet()) {
            System.out.println(key + "\t" + numbersToWords.get(key));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final int n = 1000;
        int letters = 0;
        for (int number = 1; number <= n; number++) {
            String words = toWords(number);
            if (words == null) {
                System.err.println("# null words; n = " + n);
            }
            String nrm = words.replaceAll(" ", "");
            System.out.println("# number = " + number + ";\twords = " + words + ";\tlength = " + nrm.length());
            letters += nrm.length();
        }
        System.out.println("# n = " + n + "; number of letters = " + letters);
    }

    private static String toWords(int n) {
        final String s = String.valueOf(n);
        final int l = s.length();
        if (l == 1) {
            return numbersToWords.get(n);
        } else if (l == 2) {
            if (numbersToWords.containsKey(n)) {
                return numbersToWords.get(n);
            }
            final int tens = n / 10 * 10;
            final int ones = n - tens;
            return numbersToWords.get(tens) + " " + numbersToWords.get(ones);
        } else if (l == 3) {
            final int hundreds = n / 100 * 100;
            final int remainder = (n - hundreds);
            if (numbersToWords.containsKey(remainder)) {
                return numbersToWords.get((hundreds / 100)) + " hundred and " + numbersToWords.get(remainder);
            } else {
                final int tens = (n - hundreds) / 10 * 10;
                final int ones = n - hundreds - tens;
                if (ones > 0 && tens > 0) {
                    return numbersToWords.get((hundreds / 100)) + " hundred and " + numbersToWords.get(tens) + " " + numbersToWords.get(ones);
                } else if (tens > 0) {
                    return numbersToWords.get((hundreds / 100)) + " hundred and " + numbersToWords.get(tens);
                } else {
                    return numbersToWords.get((hundreds / 100)) + " hundred";
                }
            }
        } else if (l == 4) {
            final int thousands = n / 1000 * 1000;
            return numbersToWords.get((thousands / 1000)) + " thousand";
        }
        return null;
    }
}
//
//If the numbers 1 to 5 are written out in words: one, two, three, four, five,
//then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
//
//If all the numbers from 1 to 1000 (one thousand) inclusive were written
//out in words, how many letters would be used?
//
//
//NOTE: Do not count spaces or hyphens. For example, 342 (three hundred
//and forty-two) contains 23 letters and 115 (one hundred and fifteen)
//contains 20 letters. The use of "and" when writing out numbers is in
//compliance with British usage.
//