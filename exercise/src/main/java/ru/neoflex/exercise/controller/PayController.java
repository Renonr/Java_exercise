package ru.neoflex.exercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ru.neoflex.exercise.Holidays.HolidaysArray;

@RestController
public class PayController {

    @GetMapping("/calculate/{salary}/{days}/{date}")
    public Integer calculate(@PathVariable("salary") double salary,
                             @PathVariable("days") int days,
                             @PathVariable("date") String date) {
        double aver = 29.3; //среднее количество дней в месяце
        int absoluteDays = absolute_days(days, date);

        double result = (salary/aver)*absoluteDays;

        return (int) Math.round(result);
    }

    public Integer absolute_days(int days, String date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate  = LocalDate.parse(date, dtf);
        LocalDate endDate = startDate.plusDays(days);

        HolidaysArray holidayClass = new HolidaysArray();
        LocalDate[] holidays = new LocalDate[14];
        holidays = holidayClass.getHolidays();

        int weekendCount = 0;

        LocalDate dateIterator = startDate;
        while (!dateIterator.isAfter(endDate)) {
            if (dateIterator.getDayOfWeek() == DayOfWeek.SATURDAY || dateIterator.getDayOfWeek() == DayOfWeek.SUNDAY || contains(holidays, dateIterator)
            ) {
                weekendCount++;
            }
            dateIterator = dateIterator.plusDays(1);
        }
        return days - weekendCount;
    }

    public static boolean contains(LocalDate[] array, LocalDate target){
        for (LocalDate date : array) {
            if (date.equals(target)) {
                return true;
            }
        }
        return false;
    }
}
