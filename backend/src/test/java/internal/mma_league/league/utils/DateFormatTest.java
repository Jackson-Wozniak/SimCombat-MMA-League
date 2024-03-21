package internal.mma_league.league.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateFormatTest {

    @Test
    void testAllDatesInWeek(){
        LocalDate date = LocalDate.of(2024, 3, 21); //date of this test writing

        assertEquals("March 21st, 2024", DateFormat.toWords(date));
        assertEquals("March 22nd, 2024", DateFormat.toWords(date.plusDays(1)));
        assertEquals("March 23rd, 2024", DateFormat.toWords(date.plusDays(2)));
        assertEquals("March 24th, 2024", DateFormat.toWords(date.plusDays(3)));
        assertEquals("March 25th, 2024", DateFormat.toWords(date.plusDays(4)));
        assertEquals("March 26th, 2024", DateFormat.toWords(date.plusDays(5)));
        assertEquals("March 27th, 2024", DateFormat.toWords(date.plusDays(6)));
    }

    @Test
    void testAllMonths(){
        assertEquals("January 1st, 2024", DateFormat.toWords(LocalDate.of(2024, 1, 1)));
        assertEquals("February 1st, 2024", DateFormat.toWords(LocalDate.of(2024, 2, 1)));
        assertEquals("March 1st, 2024", DateFormat.toWords(LocalDate.of(2024, 3, 1)));
        assertEquals("April 1st, 2024", DateFormat.toWords(LocalDate.of(2024, 4, 1)));
        assertEquals("May 1st, 2024", DateFormat.toWords(LocalDate.of(2024, 5, 1)));
        assertEquals("June 1st, 2024", DateFormat.toWords(LocalDate.of(2024, 6, 1)));
        assertEquals("July 1st, 2024", DateFormat.toWords(LocalDate.of(2024, 7, 1)));
        assertEquals("August 1st, 2024", DateFormat.toWords(LocalDate.of(2024, 8, 1)));
        assertEquals("September 1st, 2024", DateFormat.toWords(LocalDate.of(2024, 9, 1)));
        assertEquals("October 1st, 2024", DateFormat.toWords(LocalDate.of(2024, 10, 1)));
        assertEquals("November 1st, 2024", DateFormat.toWords(LocalDate.of(2024,  11, 1)));
        assertEquals("December 1st, 2024", DateFormat.toWords(LocalDate.of(2024, 12, 1)));
    }
}