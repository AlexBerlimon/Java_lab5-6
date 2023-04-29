package com.epam.lab.controller;

import com.epam.lab.count.RequestCountThread;
import com.epam.lab.count.RequestResponse;
import com.epam.lab.entity.DateEntity;
import com.epam.lab.entity.PostMap;
import com.epam.lab.service.DayCalcService;
import com.epam.lab.userCash.Cash;
import com.epam.lab.validator.ValidParams;
import com.epam.lab.validator.ValidResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


@RestController
@RequestMapping("api/lab")
public class DateController {
    private static final Logger logger = LogManager.getLogger(DateController.class);
    @Autowired
    private final DayCalcService dayCalcService;
    private final ValidParams paramValidator;
    private Cash cash;

    public DateController(DayCalcService dayCalcService, ValidParams paramValidator, Cash cash) {
        this.dayCalcService = dayCalcService;
        this.paramValidator = paramValidator;
        this.cash = cash;
    }

    @GetMapping(path = "/calc/")
    public ResponseEntity<Object> CalculatingDate(@RequestParam("day") int day, @RequestParam("year") int year) {

        RequestCountThread count = new RequestCountThread();
        ValidResponse responseDay = paramValidator.validateParam(day, year);
        ValidResponse responseYear = paramValidator.validateParam(day, year);

        if (responseDay.getErrorMessages().size() != 0) {
            responseDay.setStatus(HttpStatus.BAD_REQUEST);
            logger.error("Day argument is not valid");
            return new ResponseEntity<>(responseDay, HttpStatus.BAD_REQUEST);
        }
        if (responseYear.getErrorMessages().size() != 0) {
            responseYear.setStatus(HttpStatus.BAD_REQUEST);
            logger.error("Year argument is not valid");
            return new ResponseEntity<>(responseYear, HttpStatus.BAD_REQUEST);
        }
        try {
            DateEntity date = new DateEntity(day, year);
            ValidResponse validResponse = paramValidator.validateParam(day, year);
            String answer = dayCalcService.calculating(date);
            if (validResponse.getErrorMessages().size() == 0) {
                date.setDayOfWeek(answer);
                cash.saveDate(date);
                logger.info("Successfully getMapping");
                validResponse.setDate(date);
                return ResponseEntity.ok(date);
            } else {
                responseDay.addErrorMessage("Result is not valid");
                responseDay.setStatus(HttpStatus.BAD_REQUEST);
                return new ResponseEntity<>(responseDay, HttpStatus.BAD_REQUEST);
            }


        } catch (RuntimeException e) {
            responseDay.addErrorMessage("ERROR 500");
            responseDay.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            logger.error("ERROR 500");
            return new ResponseEntity<>(responseDay, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    // обработчик unchecked ошибок
    public ResponseEntity<Object> handleUnchecked(RuntimeException e) {
        RequestCountThread count = new RequestCountThread();

        ValidResponse response = new ValidResponse();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.addErrorMessage("Error 500: " + RuntimeException.class);
        logger.error("Error 500");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping(path = "/dates")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<DateEntity>> getSavedDates() {
        return ResponseEntity.ok(cash.getSavedDates());
    }

    @GetMapping(path = "/dates/size")
    @ResponseStatus(HttpStatus.OK)
    public RequestResponse getDateCount() {
        return new RequestResponse("size", cash.getDateCount());
    }

    @PostMapping("/nameOfDay")
    public ResponseEntity<Object> postNames(@Validated @RequestBody List<DateEntity> paramList) {

        List<ValidResponse> resultList = new LinkedList<>();
        List<String> resNames = new LinkedList<>();
        List<LocalDate> resDates = new LinkedList<>();

        paramList.forEach((current) -> {
            ValidResponse responseDay = paramValidator.validateParam(current.getNumberOfDay(), current.getYear());
            ValidResponse responseYear = paramValidator.validateParam(current.getNumberOfDay(), current.getYear());
            ValidResponse validResponse = new ValidResponse("Incorrect input", HttpStatus.BAD_REQUEST, new DateEntity(current.getNumberOfDay(), current.getYear(), dayCalcService.calculating(current), dayCalcService.localDateToString(dayCalcService.dateFormat(current))));
            boolean errors = false;

            if (responseDay.getErrorMessages().size() != 0) {
                responseDay.setStatus(HttpStatus.BAD_REQUEST);
                logger.error("Day argument is not valid");
                errors = true;

            }
            if (responseYear.getErrorMessages().size() != 0) {
                responseYear.setStatus(HttpStatus.BAD_REQUEST);
                logger.error("Year argument is not valid");
                errors = true;
            }
            if (errors)
                resultList.add(validResponse);
            else {
                resultList.add(new ValidResponse("", HttpStatus.OK,
                        new DateEntity(current.getNumberOfDay(), current.getYear(), dayCalcService.calculating(current), dayCalcService.localDateToString(dayCalcService.dateFormat(current)))));
                resNames.add(dayCalcService.calculating(current));
                resDates.add(dayCalcService.dateFormat(current));
            }
        });
        logger.info("Successfully post");
        String maxRes = dayCalcService.localDateToString(dayCalcService.findMaxDate(resDates));
        String minRes = dayCalcService.localDateToString(dayCalcService.findMinDate(resDates));
        PostMap map = new PostMap(resultList, resNames, maxRes, minRes);
        logger.info("Successfully postMapping result");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
}








