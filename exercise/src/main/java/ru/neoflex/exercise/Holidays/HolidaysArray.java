package ru.neoflex.exercise.Holidays;

import java.time.LocalDate;

public class HolidaysArray {
    public LocalDate[] getHolidays() {
        LocalDate[] holidays = new LocalDate[14];
        holidays[0] = LocalDate.of(2024, 1, 1);
        holidays[1] = LocalDate.of(2024, 1, 2);
        holidays[2] = LocalDate.of(2024, 1, 3);
        holidays[3] = LocalDate.of(2024, 1, 4);
        holidays[4] = LocalDate.of(2024, 1, 5);
        holidays[5] = LocalDate.of(2024, 1, 6);
        holidays[6] = LocalDate.of(2024, 1, 7);
        holidays[7] = LocalDate.of(2024, 1, 8);
        holidays[8] = LocalDate.of(2024, 2, 23);
        holidays[9] = LocalDate.of(2024, 3, 8);
        holidays[10] = LocalDate.of(2024, 5, 9);
        holidays[11] = LocalDate.of(2024, 6, 12);
        holidays[12] = LocalDate.of(2024, 11, 4);
        holidays[13] = LocalDate.of(2024, 5, 1);

        return holidays;
    }
}
