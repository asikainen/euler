/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.ArrayList;
import java.util.HashMap;
import project_euler.util.SieveOfAtkin;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem012 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        int i = 0;
//        int triangle = 0;
//        int maxsze = 0;
//        while ((i++) < 100000) {
//            triangle += i;
//            ArrayList<Integer> list = findDivisors(triangle);
//            final int sze = list.size();
//            if (sze > maxsze) {
//                maxsze = sze;
//            }
//            if (i % 100 == 0) {
//                System.out.println(i + "\t" + triangle + "\t" + maxsze);
//            }
//            if (sze > 500) {
//                break;
//            }
//        }

//        System.out.println(findDivisors(14047650).size());
        SieveOfAtkin sieve = new SieveOfAtkin(1000000);
        ArrayList<Integer> primes = sieve.run();
        final long start = 2;
        int i = 0;
        int triangle = 0;
        int maxsze = 0;
        while ((i++) < 100000) {
            triangle += i;
            if (triangle == 20100) {
                System.out.println(triangle);
            }
            final int end = triangle;
            final HashMap<Integer, Integer> pfs = new HashMap<Integer, Integer>();
            long number = triangle;
            while (number >= start) {
                for (int n = 0; n < primes.size(); n++) {
                    int pf = primes.get(n);
                    if (number < start) {
                        break;
                    }
                    if (pf > end) {
                        break;
                    }
                    if (!isDivisible(number, pf)) {
                        continue;
                    } else {
                        int cnt = 1;
                        if (pfs.containsKey(pf)) {
                            cnt += pfs.get(pf);
                        }
                        pfs.put(pf, cnt);
                        number /= pf;
                    }
                }
            }
            int numberFactors = 1;
            if (pfs.isEmpty()) {
                if (triangle > 1) {
                    numberFactors++;
                }
            }
            for (int n : pfs.values()) {
                numberFactors *= (n + 1);
            }
//            ArrayList<Integer> list = findDivisors(triangle);
//            if (list.size() != numberFactors) {
//                System.out.println("# error");
//            }
//            System.out.println(i + "\t" + triangle + "\t" + numberFactors);
            if (i % 100 == 0) {
                System.out.println(i + "\t" + triangle + "\t" + maxsze);
            }
            if (numberFactors > maxsze) {
                maxsze = numberFactors;
                if (maxsze >= 500) {
                    break;
                }
            }
        }

        // # trianle = 76576500; i = 12375; max size = 576
        System.out.println("# trianle = " + triangle + "; i = " + i + "; max size = " + maxsze);
    }

    private static boolean isDivisible(long number, long divisor) {
        final long result = number / divisor;
        return (number == (result * divisor));
    }
}
///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package project_euler.level01;
//
//import java.util.ArrayList;
//
///**
// *
// * @author Joonas Asikainen <tjasikai@mac.com>
// */
//public class Problem012 {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//
//        int i = 0;
//        int triangle = 0;
//        int maxsze = 0;
//        while ((i++) < 100000) {
//            triangle += i;
//            ArrayList<Integer> list = findDivisors(triangle);
//            final int sze = list.size();
//            if (sze > maxsze) {
//                maxsze = sze;
//            }
//            if (i % 100 == 0) {
//                System.out.println(i + "\t" + triangle + "\t" + maxsze);
//            }
//            if (sze > 500) {
////                for (int d : list) {
////                    System.out.println(d);
////                }
//                break;
//            }
//        }
//        System.out.println("# trianle = " + triangle + "; i = " + i + "; nt = " + maxsze);
//
////        ArrayList<Integer> list= findDivisors(28);
////        for (int i=0; i<list.size(); i++) {
////            System.out.println(list.get(i));
////        }
//
//        // # trianle = 76576500; i = 12375; nt = 576
//    }
//
//    private static ArrayList<Integer> findDivisors(int number) {
//
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        if (number == 1) {
//            return list;
//        }
//        final int n2 = number / 2;
//        for (int n = 2; n <= n2; n++) {
//            if (isDivisible(number, n)) {
//                list.add(n);
//            }
//        }
//        list.add(number);
//        return list;
//    }
//
//    private static boolean isDivisible(long number, long divisor) {
//        final long result = number / divisor;
//        return (number == (result * divisor));
//    }
//}

//
//The sequence of triangle numbers is generated by adding the natural numbers.
//So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
//
//1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
//
//Let us list the factors of the first seven triangle numbers:
//
// 1: 1
// 3: 1,3
// 6: 1,2,3,6
//10: 1,2,5,10
//15: 1,3,5,15
//21: 1,3,7,21
//28: 1,2,4,7,14,28
//We can see that 28 is the first triangle number to have over five divisors.
//
//What is the value of the first triangle number to have over five hundred divisors?
