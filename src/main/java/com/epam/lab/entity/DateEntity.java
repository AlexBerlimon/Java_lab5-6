package com.epam.lab.entity;

import org.springframework.stereotype.Component;

@Component
public class DateEntity {
//    @Id
//    Long Id;
    private int numberOfDay;
    private int year;
    private String dayOfWeek;

    private String date;


    public DateEntity(){
        this.numberOfDay = 0;
        this.year = 0;
        this.dayOfWeek = "";
        this.date = "";
    }
    public DateEntity(int numberOfDay, int year){
        this.numberOfDay = numberOfDay;
        this.year = year;
        this.dayOfWeek = "";
        this.date = "";
    }

    public DateEntity(int numberOfDay, int year, String dayOfWeek, String date)
    {
        this.numberOfDay = numberOfDay;
        this.year = year;
        this.dayOfWeek = dayOfWeek;
        this.date = date;
    }
    public DateEntity(DateEntity date)
    {
        this.numberOfDay = date.getNumberOfDay();
        this.year = date.getYear();
        this.dayOfWeek = date.getDayOfWeek();
    }


    public void setNumberOfDay(int numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getNumberOfDay() {
        return numberOfDay;
    }

    public int getYear() {
        return year;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DateEntity date = (DateEntity) o;
        return ((this.numberOfDay == date.numberOfDay && this.year == date.year));
    }
}

