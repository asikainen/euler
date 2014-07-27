/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * <b><i>project_euler</i></b> main class. Each of the classes
 * <b>ProblemXYZ</b> in each of the packages <i>levelXY</i>
 * solves one of the problems on http://projecteuler.net
 *
 * 
 * @author Joonas Asikainen <tjasikai@mac.com> 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            project_euler.level02.Problem051.main(args);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
