package com.epam.lab.service;


import com.epam.lab.entity.DateEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DateServiceTest {
    private DayCalcService dateServiceTest = new DayCalcService();
    @Test
    public void Test1(){
        DateEntity testDate = new DateEntity(364, 2015);
        String expectedResult = "среда";
        Assertions.assertEquals(expectedResult, dateServiceTest.calculating(testDate));
    }
    @Test
    public void Test2(){
        DateEntity testDate = new DateEntity (366, 2000);
        String expectedResult = "воскресенье";
        Assertions.assertEquals(expectedResult, dateServiceTest.calculating(testDate));
    }

        


}

