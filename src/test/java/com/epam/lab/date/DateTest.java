package com.epam.lab.date;

import com.epam.lab.entity.DateEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateTest {

    @Test
    void DateEquals(){
        DateEntity date1 = new DateEntity();
        DateEntity date2 = new DateEntity();

        boolean res = date1.equals(date2);
        Assertions.assertTrue(res);
    }

    @Test
    void DateEqualsAll(){
        DateEntity date1 = new DateEntity(365, 2020);
        DateEntity date2 = new DateEntity(365, 2020);
    boolean res = date1.equals(date2);
    Assertions.assertTrue(res);
    }
}
