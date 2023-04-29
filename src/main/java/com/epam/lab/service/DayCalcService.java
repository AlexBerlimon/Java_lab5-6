package com.epam.lab.service;

import com.epam.lab.entity.DateEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Service
public class DayCalcService {

    private static final Logger logger = LogManager.getLogger(DateEntity.class);

    @Autowired
    public DayCalcService() {
    }


    public String calculating(DateEntity date1) {
        int dayNumber = date1.getNumberOfDay();  // Example day number
        int year = date1.getYear();              // Example year

        LocalDate date = LocalDate.ofYearDay(year, dayNumber);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        String DayofWeekStr = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());
        logger.info("Day of week");
        return DayofWeekStr;
    }

    public LocalDate dateFormat(DateEntity date1) {
        int dayNumber = date1.getNumberOfDay();  // Example day number
        int year = date1.getYear();
        LocalDate date = LocalDate.ofYearDay(year, dayNumber);
        return date;
    }

    public LocalDate findMaxDate(List<LocalDate> dates) {
        return dates.stream()
                .max(LocalDate::compareTo)
                .orElse(null);

    }

    public LocalDate findMinDate(List<LocalDate> dates) {
        return dates.stream()
                .min(LocalDate::compareTo)
                .orElse(null);

    }

    public String localDateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

}