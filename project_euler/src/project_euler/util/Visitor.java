/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.util;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Visitor {

    private int level = -1;
    private final int[] array;

    public static void main(String[] args) {
        final int[] data = new int[]{1, 3, 5};
        Visitor v = new Visitor(data);
        v.run();
    }

    public Visitor(int[] array) {
        this.array = array;
    }

    public void run() {

        final int n = array.length;
        final int[] v = new int[n];
        visit(v, n, 0);
    }

    private void visit(int[] v, int n, int k) {

        level = level + 1;
        v[k] = level;

        if (level == n) {
            System.out.println("# new visit:");
            for (int i = 0; i < n; i++) {
                System.out.print(v[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(array[v[i] - 1] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (v[i] == 0) {
                    visit(v, n, i);
                }
            }
        }

        level = level - 1;
        v[k] = 0;
    }
}

