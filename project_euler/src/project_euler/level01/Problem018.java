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
public class Problem018 {

    private static int maxSum = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FieldFileReader reader = new FieldFileReader("./data/problem018.input.txt", "\\s+");
            int row = 0;
            String[] fields = null;
            while ((fields = reader.readFields()) != null) {
                row++;
                System.out.println(Arrays.toString(fields));
            }
            System.out.println("# rows = " + row + "; routes = " + (int) Math.pow(2.0, (row - 1)));

            final int[][] triangle = new int[row][];
            reader = new FieldFileReader("./data/problem018.input.txt", "\\s+");
            row = 0;
            fields = null;
            while ((fields = reader.readFields()) != null) {
                triangle[row] = new int[fields.length];
                for (int col = 0; col < fields.length; col++) {
                    triangle[row][col] = Integer.parseInt(fields[col]);
                }
                row++;
            }

            traverse(triangle, 0, 0, triangle[0][0]);

            System.out.println("# max sum = " + maxSum);
        } catch (Exception ex) {
            Logger.getLogger(Problem018.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void traverse(int[][] triangle, int row, int col, int sum) {
        final int rows = triangle.length;
        if (row == rows) {
            return;
        }
        if (row == rows - 1) {
            if (sum > maxSum) {
                maxSum = sum;
            }
            System.out.println(row + "\t" + col + "\t" + triangle[row][col] + "\t" + sum);
        }

        final int left = col;
        final int sumL = row < rows - 1 ? sum + +triangle[row + 1][left] : sum;
        traverse(triangle, row + 1, left, sumL);

        final int right = col + 1;
        final int sumR = row < rows - 1 ? sum + +triangle[row + 1][right] : sum;
        traverse(triangle, row + 1, right, sumR);
    }
}
//By starting at the top of the triangle below and moving to adjacent
//numbers on the row below, the maximum total from top to bottom is 23.
//
//3
//7 4
//2 4 6
//8 5 9 3
//
//That is, 3 + 7 + 4 + 9 = 23.
//
//Find the maximum total from top to bottom of the triangle below:
//
//75
//95 64
//17 47 82
//18 35 87 10
//20 04 82 47 65
//19 01 23 75 03 34
//88 02 77 73 07 63 67
//99 65 04 28 06 16 70 92
//41 41 26 56 83 40 80 70 33
//41 48 72 33 47 32 37 16 94 29
//53 71 44 65 25 43 91 52 97 51 14
//70 11 33 28 77 73 17 78 39 68 17 57
//91 71 52 38 17 14 91 43 58 50 27 29 48
//63 66 04 68 89 53 67 30 73 16 69 87 40 31
//04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
//
//NOTE: As there are only 16384 routes, it is possible to solve this problem
//by trying every route. However, Problem 67, is the same challenge with a
//triangle containing one-hundred rows; it cannot be solved by brute
//force, and requires a clever method! ;o)