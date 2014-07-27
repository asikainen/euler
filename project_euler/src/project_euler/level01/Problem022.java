/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import project_euler.util.FieldFileReader;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FieldFileReader reader = new FieldFileReader("./data/problem022.input.txt", ",");
            int row = 0;
            String[] fields = reader.readFields();
            Arrays.sort(fields);
            for (int i = 0; i < fields.length; i++) {
                fields[i] = fields[i].replaceAll("\"", "").toLowerCase();
            }

            long total = 0;
            for (int i = 0; i < fields.length; i++) {
                final int idx = (i + 1);
                final String name = fields[i];
//                if (idx == 938) {
                int score = 0;
                for (char c : name.toCharArray()) {
                    final int val = (int) (c - 'a') + 1;
                    score += val;
                }
                total += (long) (score * idx);
                System.out.println(idx + "\t" + fields[i] + "\t" + score * idx);
//                }
            }
            System.out.println("# total of scores = " + total);
        } catch (Exception ex) {
            Logger.getLogger(Problem018.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
//
//Using names
//.txt (right click and 'Save Link/Target As...'), a 46K text file
//containing over five-thousand first names, begin by sorting it into
//alphabetical order. Then working out the alphabetical value for each name,
//multiply this value by its alphabetical position in the list to obtain a name score.
//
//For example, when the list is sorted into alphabetical order, COLIN,
//which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
//So, COLIN would obtain a score of 938  53 = 49714.
//
//What is the total of all the name scores in the file?
