/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.util;

import java.util.Arrays;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Rotator {

    private final int[] data;
    private int index;

    public Rotator(int[] data) {
        this.data = data;
        this.index = 0;
    }

    public int[] next() {
        if (index >= data.length) {
            return null;
        }
        final int[] rotation = new int[data.length];
        int idx = 0;
        for (int i = index; i < data.length; i++) {
            rotation[idx++] = data[i];
        }
        for (int i = 0; i < index; i++) {
            rotation[idx++] = data[i];
        }
//        System.out.println(index + "; " + Arrays.toString(rotation));
        index++;
        return rotation;
    }
}
