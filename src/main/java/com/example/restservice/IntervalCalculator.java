package com.example.restservice;

import java.util.Date;

public class IntervalCalculator {
    static int monthDays[] = {31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31};

    // This function counts number of
    // leap years before the given date
    static int countLeapYears(Date date)
    {
        int years = date.getYear();

        // Check if the current year needs to be considered
        // for the count of leap years or not
        if (date.getMonth() <= 2)
        {
            years--;
        }

        // An year is a leap year if it is a multiple of 4,
        // multiple of 400 and not a multiple of 100.
        return years / 4 - years / 100 + years / 400;
    }

    // This function returns number
    // of days between two given dates
    static int getDifference(Date givenDate, Date currentDate)
    {
        // COUNT TOTAL NUMBER OF DAYS BEFORE FIRST DATE 'givenDate'

        // initialize count using years and day
        int daysOfGivenDate = givenDate.getYear() * 365 + givenDate.getDate();

        // Add days for months in given date
        for (int i = 0; i < givenDate.getMonth() - 1; i++)
        {
            daysOfGivenDate += monthDays[i];
        }

        // Since every leap year is of 366 days,
        // Add a day for every leap year
        daysOfGivenDate += countLeapYears(givenDate);

        // SIMILARLY, COUNT TOTAL NUMBER OF DAYS BEFORE 'dt2'
        int daysOfCurrentDate = currentDate.getYear() * 365 + currentDate.getDate();
        for (int i = 0; i < currentDate.getMonth() - 1; i++)
        {
            daysOfCurrentDate += monthDays[i];
        }
        daysOfCurrentDate += countLeapYears(currentDate);

        // return difference between two counts
        return Math.abs(daysOfCurrentDate - daysOfGivenDate);
    }
}
