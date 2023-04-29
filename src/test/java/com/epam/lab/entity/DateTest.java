package com.epam.lab.entity;

import com.epam.lab.validator.ValidParams;
import com.epam.lab.validator.ValidResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateTest {
    private ValidParams paramValidator = new ValidParams();
    @Test
    void DateEquals(){
        DateEntity date1 = new DateEntity();
        DateEntity date2 = new DateEntity();

        boolean res = date1.equals(date2);
        Assertions.assertTrue(res);
    }
    @Test
    public void testValidParam() {
        DateEntity date = new DateEntity(234, 2000);
        ValidResponse responseDay = paramValidator.validateParam(date.getNumberOfDay(), date.getYear());
        ValidResponse responseYear = paramValidator.validateParam(date.getNumberOfDay(), date.getYear());
        Assertions.assertEquals(responseDay.getErrorMessages().size(), 0);
        Assertions.assertEquals(responseYear.getErrorMessages().size(), 0);
    }

    @Test
    public void testError() {
        DateEntity date = new DateEntity(400, 2000);
        ValidResponse responseDay = paramValidator.validateParam(date.getNumberOfDay(), date.getYear());
        ValidResponse responseYear = paramValidator.validateParam(date.getNumberOfDay(), date.getYear());
        Assertions.assertEquals(responseDay.getErrorMessages().size(), 1);
        Assertions.assertEquals(responseYear.getErrorMessages().size(), 1);
    }



}
