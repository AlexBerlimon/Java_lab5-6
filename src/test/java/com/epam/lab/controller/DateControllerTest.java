package com.epam.lab.controller;

import com.epam.lab.entity.DateEntity;
import com.epam.lab.service.DayCalcService;
import com.epam.lab.userCash.Cash;
import com.epam.lab.validator.ValidParams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class DateControllerTest {

    private DayCalcService service = mock(DayCalcService.class);
    private ValidParams validParams = mock(ValidParams.class);
    private Cash cash = new Cash();

    @InjectMocks
    private DateController dateController = new DateController(service, validParams, cash);
    private static final DateEntity date = mock(DateEntity.class);
    @BeforeAll
    public static void setup(){
        when(date.getNumberOfDay()).thenReturn(364);
        when(date.getYear()).thenReturn(2015);
    }
//    @Test
//    public void validateParamFalse(){
//        when(validParams.validateParam(Integer.MAX_VALUE+1, Integer.MAX_VALUE+1)).thenReturn(new ValidResponse("Bad Request", HttpStatus.BAD_REQUEST));
//        when(validParams.validateParam(0, 0)).thenReturn(new ValidResponse("Bad request", HttpStatus.BAD_REQUEST));
//
//        when(validParams.validateParam(date.getNumberOfDay(), date.getYear())).thenReturn(new ValidResponse());
//        when(validParams.validateParam(367, 4000)).thenReturn(new ValidResponse("Bad request", HttpStatus.BAD_REQUEST));
//        ResponseEntity<Object> case1 = dateController.CalculatingDate(3670, date.getYear());
//        Assertions.assertEquals(HttpStatus.BAD_REQUEST, case1.getStatusCode());
//      }
//    @Test
//    void validateParamTrue(){
//       DateEntity date = new DateEntity(1, 2021);
//        when(validParams.validateParam(date.getNumberOfDay(),date.getYear())).thenReturn(new ValidResponse());
//
//        when(service.calculating(date)).thenReturn("пятница");
//        ResponseEntity<Object> objectResponseEntity = dateController.CalculatingDate(date.getNumberOfDay(), date.getYear());
//        Assertions.assertEquals(HttpStatus.OK, objectResponseEntity.getStatusCode());
//    }
    @Test
    void cashTest(){
       cash.saveDate(date);
       Assertions.assertEquals(cash.getDateCount(), dateController.getDateCount().getCount());
       Assertions.assertEquals(ResponseEntity.ok(cash.getSavedDates()), dateController.getSavedDates());
   }
}
