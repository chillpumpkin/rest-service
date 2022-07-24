package com.example.restservice;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

@RestController
public class IntervalCalculatorController {

    @GetMapping("/interval-calculator")
    public String intervalCalculator(@RequestParam(value = "date") String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setLenient(false);

        try {
            Date givenDate = formatter.parse(date);
            Date currentDate = new Date();

            return String.format("Day difference between "+ givenDate.toGMTString() + " and " + currentDate.toGMTString() + " is: " +  IntervalCalculator.getDifference(givenDate, currentDate));

        } catch (ParseException e) {
            throw new ParseException("Invalid date! Date does not exist.",e.getErrorOffset());
        }
    }
}
