package com.roknikolic.calendarapp;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CalendarHelper {
    LocalDate currentDate = LocalDate.now();
    // Map of month keys
    private final Map<Integer, Integer> monthKeys = new HashMap<>();
    public CalendarHelper() {
        monthKeys.put(1, 1);
        monthKeys.put(2, 4);
        monthKeys.put(3, 4);
        monthKeys.put(4, 0);
        monthKeys.put(5, 2);
        monthKeys.put(6, 5);
        monthKeys.put(7, 0);
        monthKeys.put(8, 3);
        monthKeys.put(9, 6);
        monthKeys.put(10, 1);
        monthKeys.put(11, 4);
        monthKeys.put(12, 6);
    }
    public int getCurrentYear() {
        return currentDate.getYear();
    }
    public int gerCurrentMonth() {
        return currentDate.getMonthValue();
    }
    public String getCurrentMonthName() {
        String monthString = String.valueOf(currentDate.getMonth());
        return monthString.charAt(0) + monthString.substring(1).toLowerCase();
    }
    public boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return year % 4 == 0;
        }
    }
    public int numOfDaysInMonth(int month, int year) {
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else return 28;
        } else if ((month < 8 && month % 2 != 0) || (month >= 8 && month % 2 == 0)) {
            return 31;
        } else return 30;

    }
    public int getWeekDayForDate(int day, int month, int year) {
        // Zeller's congruence for the Gregorian calendar
        if (month < 3) {
            year--;
            month += 12;
        }
        // long formula
        int daysTerm = day + ((13 * (month + 1)) / 5);
        int last2digits = year % 100;
        int decadesPart = last2digits + (last2digits / 4);
        int first2digits =  year / 100;
        int millenniaPart = (first2digits / 4) + (5 * first2digits); // We add 5 instead of - 2 to avoid underflow
        int dayOfTheWeek = (daysTerm + decadesPart + millenniaPart) % 7;

        // simplified formula
        int dayOfTheWeek2 = (day + ((13 * (month + 1)) / 5) + year + (year / 4) - (year / 100) + (year / 400)) % 7;

        // Returns numbers from 1 to 7 for Monday to Sunday
        return ((dayOfTheWeek2 + 5) % 7) + 1;
    }
    public int getFirstDayOfMonth(int month, int year) {
        return getWeekDayForDate(1, month, year);
    }
}
