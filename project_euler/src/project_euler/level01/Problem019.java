/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_euler.level01;

import java.util.Calendar;

/**
 *
 * @author Joonas Asikainen <tjasikai@mac.com>
 */
public class Problem019 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final int daysInWeek = 7;
        final int months = 12;
        final String[] weekDays = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        final String[] monthNames = new String[]{"January", "February", "March", "April", "May", "June", "Julyl", "August", "September", "October", "November", "December"};

        int sundaysOfInterest = 0;
        int days = 1; // running week day counter
        int day = 0; // starting day of month
        int month = 0; // starting month
        int year = 1900; // starting year
        while (year < 2001) {

            // check if Sunday on the first of month
            final int weekday = days % daysInWeek;
//            System.out.println(weekDays[weekday] + "\t" + day + "\t" + monthNames[month] + "\t" + month + "\t" + year);
            if (day == 0 && weekday == 0) {
                if (year > 1900 && year < 2001) {
                    System.out.println(weekDays[weekday] + "\t" + day + "\t" + monthNames[month] + "\t" + month + "\t" + year);
                    sundaysOfInterest++;
                }
            }

            // increase day
            day++;
            days++;

            // check for change of month
            int daysInMonth = getDaysInMonth(month, year);
            if (day == daysInMonth) { // zero based days
                day = 0;
                month++;
            }

            // check if year changes
            if (month == months) { // zero based months
                year++;
                month = 0;
            }
        }

        System.out.println("# number of Sundays = " + sundaysOfInterest);
    }

    private static int getDaysInMonth(int month, int year) {
        int daysInMonth = 31;

        // april, june, september, november
        if (month == 3 || month == 5 || month == 8 || month == 10) {
            daysInMonth = 30;
        } else if (month == 1) { // february
            daysInMonth = 28;
            if (isLeapYear(year)) {
                daysInMonth = 29; // leap year
            }
        }
        return daysInMonth;
    }

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }
// You are given the following information, but you may prefer to do some research for yourself.
//
// 1 Jan 1900 was a Monday.
// Thirty days has September,
// April, June and November.
// All the rest have thirty-one,
// Saving February alone,
// Which has twenty-eight, rain or shine.
// And on leap years, twenty-nine.
// 
// A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
//
// How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
}
