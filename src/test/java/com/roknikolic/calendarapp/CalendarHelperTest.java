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
        assertEquals(31, result);
    }
    @Test
    void numOfDaysInMonthFebLeap() {
        int result = calendarHelper.numOfDaysInMonth(2, 2024);
        assertEquals(29, result);
    }
    @Test
    void numOfDaysInMonthFebNormal() {
        int result = calendarHelper.numOfDaysInMonth(2, 2023);
        assertEquals(28, result);
    }
    @Test
    void numOfDaysInMonthOddSecondHalf() {
        int result = calendarHelper.numOfDaysInMonth(11, 2024);
        assertEquals(30, result);
    }
    @Test
    void numOfDaysInMonthEvenSecondHalf() {
        int result = calendarHelper.numOfDaysInMonth(12, 2024);
        assertEquals(31, result);
    }
    @Test
    void dayOfTheWeek1() {
        int result = calendarHelper.getWeekDayForDate(1,1, 2024);
        assertEquals(1, result);
    }
    @Test
    void dayOfTheWeek2() {
        int result = calendarHelper.getWeekDayForDate(4,1, 2024);
        assertEquals(4, result);
    }
    @Test
    void dayOfTheWeek3() {
        int result = calendarHelper.getWeekDayForDate(1,3, 1000);
        assertEquals(6, result);
    }
    @Test
    void dayOfTheWeek4() {
        int result = calendarHelper.getWeekDayForDate(9,7, 1255);
        assertEquals(5, result);
    }
    @Test
    void dayOfTheWeek5() {
        int result = calendarHelper.getWeekDayForDate(1,4, 3000);
        assertEquals(2, result);
    }
    @Test
    void dayOfTheWeek6() {
        int result = calendarHelper.getWeekDayForDate(1,3, 300);
        assertEquals(4, result);
    }
    @Test
    void firstDayOfMonth1() {
        int result = calendarHelper.getFirstDayOfMonth(2, 2024);
        assertEquals(4, result);
    }
    @Test
    void firstDayOfMonth2() {
        int result = calendarHelper.getFirstDayOfMonth(6, 1344);
        assertEquals(1, result);
    }
}