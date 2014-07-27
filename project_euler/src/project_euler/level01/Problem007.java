/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import project_euler.util.PrimeFinder;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem007 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            final int howMany = 10001;
            int number = 2;
            int np = 0;
            while (np < howMany) {
                if (PrimeFinder.isPrime((long) number)) {
                    np++;
                    System.out.println(np + "\t" + number);
                }
                number++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
//
//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//
//What is the 10001st prime number?
//