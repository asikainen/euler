/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import project_euler.util.FieldFileReader;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem042 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        final HashMap<Integer, Integer> triangles = getTriangles(10000);
        FieldFileReader reader = new FieldFileReader("./data/problem042.input.txt", ",");
        int cnt = 0;
        String[] fields = null;
        while ((fields = reader.readFields()) != null) {
            for (String field : fields) {
                final String word = field.substring(1, field.length() - 1).toLowerCase();
                final int number = getWordValue(word);
                if (triangles.containsKey(number)) {
                    System.out.println("# word = '" + word + "' is triangle.");
                    cnt++;
                }
            }
        }
        System.out.println("# number of triangle words = " + cnt);
    }

    private static int getWordValue(String word) {
        int value = 0;
        for (char c : word.toCharArray()) {
            value += (c - 'a' + 1);
        }
        return value;
    }

    private static HashMap<Integer, Integer> getTriangles(int max) {
        final HashMap<Integer, Integer> triangles = new HashMap<Integer, Integer>(2 * max);
        int triangle = 0;
        for (int i = 1; i <= max; i++) {
            triangle += i;
            triangles.put(triangle, i);
//            System.out.println(i + "\t" + triangle);
        }
        return triangles;
    }
}
//
// The nth term of the sequence of triangle numbers is given by,
// tn = ½n(n+1); so the first ten triangle numbers are:
//
// 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
//
// By converting each letter in a word to a number corresponding to its
// alphabetical position and adding these values we form a word value.
// For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word
// value is a triangle number then we shall call the word a triangle word.
//
// Using words.txt (right click and 'Save Link/Target As...'), a 16K text
// file containing nearly two-thousand common English words, how many
// are triangle words?
//

