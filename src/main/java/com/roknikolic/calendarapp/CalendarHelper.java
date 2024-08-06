package com.roknikolic.calendarapp;

import java.time.LocalDate;

public class CalendarHelper {
    LocalDate currentDate = LocalDate.now();
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
}
