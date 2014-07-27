/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.Arrays;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem028 {

    public static void main(String[] args) {
        final int n = 1001;
        final int n2 = n / 2;
        final int nn = n * n;
        final int[][] m = new int[n][n];
        final int[] dx = new int[]{0, 1, 0, -1};
        final int[] dy = new int[]{1, 0, -1, 0};
        final int[] xy = new int[]{n2, n2};


        int dir = 3;
        System.out.println(Arrays.toString(dx));
        System.out.println(Arrays.toString(dy));
        int index = 1;
        m[xy[0]][xy[1]] = index;
        while (index <= nn) {
            dir = step(dir, n, n, dx, dy, xy, m);
            m[xy[0]][xy[1]] = (++index);
        }
        System.out.println("# --- " + index + " --- " + dir + " ---");
        print(m, n, n);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += m[i][i];
        }
        sum -= m[n2][n2];
        for (int i = 0; i < n; i++) {
            sum += m[i][n -1 - i];
        }
        System.out.println("# sum of diagonal terms = " + sum);
    }

    private static int step(int dir, int rows, int cols, int[] dx, int[] dy, int[] xy, int[][] m) {
        dir++;
        if (dir > 3) {
            dir = 0;
        }
        final int xc = xy[0];
        final int yc = xy[1];
        int x = xc + dx[dir];
        int y = yc + dy[dir];
        int turns = 0;
        while ((x < 0 || x >= rows || y < 0 || y >= cols || m[x][y] > 0) && turns < 4) {
            turns++;
            dir--;
            if (dir < 0) {
                dir = 3;
            }
            x = xc + dx[dir];
            y = yc + dy[dir];
        }
        xy[0] = x;
        xy[1] = y;
        return dir;
    }

    private static void print(int[][] m, int rows, int cols) {
        if (rows > 25 || cols > 25) {
            return;
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                final StringBuilder sb = new StringBuilder();
                final String str = String.valueOf(m[r][c]);
                while (sb.length() + str.length() < 4) {
                    sb.append(" ");
                }
                sb.append(str);
                System.out.print(sb.toString());
            }
            System.out.println();
        }
    }
}
//
//Starting with the number 1 and moving to the right in a clockwise
//direction a 5 by 5 spiral is formed as follows:
//
//21 22 23 24 25
//20  7  8  9 10
//19  6  1  2 11
//18  5  4  3 12
//17 16 15 14 13
//
//It can be verified that the sum of the numbers on the diagonals is 101.
//
//What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
//formed in the same way?
//