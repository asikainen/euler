/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.HashMap;
import project_euler.util.PrimeFactors;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem047 {

    public static void main(String[] args) {

        HashMap<Integer, Integer> pfs = null;
        int result = 0;
        int number = 4;
        boolean found = false;
        while (!found) {
            pfs = PrimeFactors.get(number);
            if (pfs.size() != 4) {
                number++;
                continue;
            }
            pfs = PrimeFactors.get(number + 1);
            if (pfs.size() != 4) {
                number += 2;
                continue;
            }
            pfs = PrimeFactors.get(number + 2);
            if (pfs.size() != 4) {
                number += 3;
                continue;
            }
            pfs = PrimeFactors.get(number + 3);
            if (pfs.size() != 4) {
                number += 4;
                continue;
            } else {
                result = number;
                break;
            }
        }
        System.out.println("# result = " + result);
        System.out.println(PrimeFactors.get(result));
        System.out.println(PrimeFactors.get(result + 1));
        System.out.println(PrimeFactors.get(result + 2));
        System.out.println(PrimeFactors.get(result + 3));
    }
}
//
// The first two consecutive numbers to have two distinct prime factors are:
//
// 14 = 2 x 7
// 15 = 3 x 5
//
// The first three consecutive numbers to have three distinct prime factors are:
//
// 644 = 2² x 7 x 23
// 645 = 3 x 5 x 43
// 646 = 2 x 17 x 19.
//
// Find the first four consecutive integers to have four distinct primes factors.
// What is the first of these numbers?
//

