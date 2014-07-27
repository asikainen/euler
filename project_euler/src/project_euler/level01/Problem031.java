/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.Arrays;

/**
 * Coin combination counting. The method <i>loop(...)</i>
 * implements recursive looping which might come in handy at times.
 * Seems to be taking a lot of time, though.
 * 
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem031 {

    private final static int target = 200;
    private static int count = 0;

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        final int[] coins = new int[] {1, 2, 5, 10, 20, 50, 100, 200};
//        final int[] coins = new int[]{1, 2, 5, 10};
        final int[] limits = new int[coins.length];
        for (int i = 0; i < limits.length; i++) {
            limits[i] = target / coins[i];
        }
        final int[] counts = new int[coins.length];
        loop(coins, limits, counts, 0);
        System.out.println("# count = " + count);
    }

    /**
     * 
     * @param coins
     * @param limits
     * @param index
     * @param sumOfCoins
     * @param maxIndex
     */
    private static void loop(int[] coins, int[] limits, int[] counts, int index) {
        if (index == coins.length) {
            final int sum = sum(coins, counts);
            if (sum == target) {
//                System.out.println(Arrays.toString(coins));
//                System.out.println(Arrays.toString(counts));
                count++;
            }
            return;
        }
//        System.out.println("# going into loop with index = " + index);
        for (int i = 0; i <= limits[index]; i++) {
            counts[index] = i;
            loop(coins, limits, counts, index + 1);
//            System.out.println(index + "\t" + i + "\t" + data[index] + "\t" + sum);
        }
    }

    /**
     * 
     * @param coins
     * @param counts
     * @return
     */
    private static int sum(int[] coins, int[] counts) {
        int sum = 0;
        for (int i = 0; i < coins.length; i++) {
            sum += (coins[i] * counts[i]);
        }
        return sum;
    }

    /**
     * 
     * @param coins
     * @param counts
     * @param max
     * @return
     */
    private static int sum(int[] coins, int[] counts, int max) {
        int sum = 0;
        for (int i = 0; i < max; i++) {
            sum += (coins[i] * counts[i]);
        }
        return sum;
    }
}
//
// In England the currency is made up of pound, £, and pence, p, and
// there are eight coins in general circulation:
//
// 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
// It is possible to make £2 in the following way:
//
// 1 x £1 + 1 x 50p + 2 x 20p + 1 x 5p + 1 x 2p + 3 x 1p
// 
// How many different ways can £2 be made using any number of coins?
//

