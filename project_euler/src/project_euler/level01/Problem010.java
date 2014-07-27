/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.ArrayList;
import project_euler.util.SieveOfAtkin;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem010 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            final int max = 2000000;
//            int np = 0;
//            long sum = 0;
//            long number = (int) PrimeFinder.getFirstPrime();
//            while (number < max) {
//                if (PrimeFinder.isPrime(number)) {
//                    sum += number;
//                    np++;
//                    //System.out.println(np + "\t" + number + "\t" + sum);
//                }
//                number++;
//                if (number % 100000 == 0) {
//                    System.out.println(np + "\t" + number + "\t" + sum);
//                }
//            } // this was correct; 
//            System.out.println("# number of primes = " + np + "; sum = " + sum);
            // # number of primes = 148933; sum = 142913828922; took 4 min 46 sec
            // # number of primes = 148933; sum = 142913828922; took 0 seconds


            SieveOfAtkin sa = new SieveOfAtkin(max);
            ArrayList<Integer> list = sa.run();
            long sum = 0;
            for (int p : list) {
                //System.out.print(p);System.out.print(", ");
                sum += (long)p;
            }
            System.out.println("# number of primes = " + list.size() + "; sum = " + sum);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
//
//The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//
//Find the sum of all the primes below two million.
//