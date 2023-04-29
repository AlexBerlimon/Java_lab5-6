package com.epam.lab.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ValidParams {
    private static final Logger logger = LogManager.getLogger(ValidParams.class);

        public ValidResponse validateParam (int day, int year){
            boolean flag = true;
            ValidResponse response = new ValidResponse();
            if (year == 0) {
                logger.error("Day value can't be less or equal to zero (<=0)");
                response.addErrorMessage("Param can't be less or equal to zero (<=0)");
            }
            if (year > 3000) {
                logger.error("Year must be less than 3000");
                response.addErrorMessage("Param can't be less than 3000");
            }
        if (day <= 0) {
            logger.error("Param value can't be less or equal to zero (<=0)");
            response.addErrorMessage("Param can't be less or equal to zero (<=0)");
        }
        if (year%4 == 0) {
            if (year%100 != 0 && year%400 == 0) flag = false;
        }
        if (flag && day >365)
        {
            logger.error("Year is common and can't be more than 365");
            response.addErrorMessage("Year is common and can't be more than 365");
        }else
            if (!flag && day >366){
                logger.error("Year is leap and can't be more than 366");
                response.addErrorMessage("Year is leap and can't be more than 366");
            }

            return response;
        }
    public ValidResponse validateParam (int day){
        boolean flag = true;
        ValidResponse response = new ValidResponse();


        if (day <= 0 || day > 366) {
            logger.error("Param value can't be less or equal to zero (<=0)");
            response.addErrorMessage("Param can't be less or equal to zero (<=0)");
        }


        return response;
    }


}