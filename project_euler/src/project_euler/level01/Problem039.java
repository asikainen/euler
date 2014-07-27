/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem039 {

    public static void main(String[] args) {

        try {

            final int pmax = 1000;
            final int[] ps = new int[pmax + 1];
            for (int a = 1; a < pmax; a++) {
                for (int b = a + 1; b < pmax; b++) {
                    if ((a + b) > pmax) {
                        break; // shortcut
                    }
                    for (int c = b + 1; c < pmax; c++) {
                        final int p = a + b + c;
                        if (p > pmax) {
                            break;
                        }
                        if (((a * a) + (b * b)) == (c * c)) {
                            ps[p]++;
                        }
                    }
                }
            }

            int maxs = 0;
            int maxp = 0;
            for (int p = 0; p < (pmax + 1); p++) {
                if (ps[p] > 0) {
                    if (ps[p] > maxs) {
                        maxp = p;
                        maxs = ps[p];
                    }
                    System.out.println(p + "\t" + ps[p]);
                }
            }
            System.out.println("# max(p) and max(s) are: " + maxp + "\t" + maxs);

        } catch (Exception ex) {
            Logger.getLogger(Problem039.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
