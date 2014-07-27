/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem014 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        for (int i = 0; i < 10; i++) {
//            System.out.println((i) + "\t" + (i >> 0x01) + "\t" + (i % 2) + "\t" + (i & 0x01));
//        }

        int maxnumber = 0;
        int maxcount = 0;
        for (int number = 1; number < 1000000; number++) {
            int count = 1;
            long n = (long)number;
//            System.out.println(n);
            do {
                n = next(n);
                count++;
//                System.out.println(n);
            } while (n > 1);
//            System.out.println("# count = " + count);
            if (count >= maxcount) {
                maxcount = count;
                maxnumber = number;
            }
            if (number % 100000 == 0) {
                System.out.println(number + "\t" + count + "\t" + maxnumber + "\t" + maxcount);
            }
        }
        System.out.println("# max number = " + maxnumber + "; max count = " + maxcount);

    }

    private static long next(long n) {
        if ((n & 0x01) == 0) {
            return n >> 0x01;
        } else {
            return (3 * n + 1);
        }
    }
}
//
//The following iterative sequence is defined for the set of positive integers:
//
//n  n/2 (n is even)
//n  3n + 1 (n is odd)
//
//Using the rule above and starting with 13, we generate the following sequence:
//
//13  40  20  10  5  16  8  4  2  1
//It can be seen that this sequence (starting at 13 and finishing at 1)
//contains 10 terms. Although it has not been proved yet (Collatz Problem),
//it is thought that all starting numbers finish at 1.
//
//Which starting number, under one million, produces the longest chain?
//
//NOTE: Once the chain starts the terms are allowed to go above one million.
//