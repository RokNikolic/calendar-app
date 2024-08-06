package com.roknikolic.calendarapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarHelperTest {
    CalendarHelper calendarHelper = new CalendarHelper();

    @Test
    void isLeapYear2024() {
        boolean result = calendarHelper.isLeapYear(2024);
        assertTrue(result);
    }
    @Test
    void isLeapYear2011() {
        boolean result = calendarHelper.isLeapYear(2011);
        assertFalse(result);
    }
    @Test
    void isLeapYear0() {
        boolean result = calendarHelper.isLeapYear(0);
        assertTrue(result);
    }
    @Test
    void isLeapYear1900() {
        boolean result = calendarHelper.isLeapYear(1900);
        assertFalse(result);
    }
    @Test
    void isLeapYear2700() {
        boolean result = calendarHelper.isLeapYear(2700);
        assertFalse(result);
    }
    @Test
    void isLeapYearNegative() {
        boolean result = calendarHelper.isLeapYear(-4);
        assertTrue(result);
    }
    @Test
    void numOfDaysInMonthOddFirstHalf() {
        int result = calendarHelper.numOfDaysInMonth(1, 2024);
        assertEquals(result, 31);
    }
    @Test
    void numOfDaysInMonthFebLeap() {
        int result = calendarHelper.numOfDaysInMonth(2, 2024);
        assertEquals(result, 29);
    }
    @Test
    void numOfDaysInMonthFebNormal() {
        int result = calendarHelper.numOfDaysInMonth(2, 2023);
        assertEquals(result, 28);
    }
    @Test
    void numOfDaysInMonthOddSecondHalf() {
        int result = calendarHelper.numOfDaysInMonth(11, 2024);
        assertEquals(result, 30);
    }
    @Test
    void numOfDaysInMonthEvenSecondHalf() {
        int result = calendarHelper.numOfDaysInMonth(12, 2024);
        assertEquals(result, 31);
    }

}