/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem009 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final int max = 1000;
        int product = 1;
        for (int a = 0; a < max; a++) {
            for (int b = a + 1; b < max; b++) {
                for (int c = b + 1; c < max; c++) {
                    if ((a + b + c) == max) {
                        if ((a * a + b * b) == (c * c)) {
                            product = a * b * c;
                            System.out.println(a + "\t" + b + "\t" + c + "\t" + product);
                            return;
                        }
                    }
                }
            }
        }
    }
}
//
//A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,
//
//a2 + b2 = c2
//For example, 32 + 42 = 9 + 16 = 25 = 52.
//
//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//Find the product abc.
//