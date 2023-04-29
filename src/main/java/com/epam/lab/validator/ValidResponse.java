package com.epam.lab.validator;

import com.epam.lab.entity.DateEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ValidResponse {
    private List<String> errorMessages;
    private HttpStatus status;
    private DateEntity date;
    public ValidResponse(){
        this.errorMessages = new ArrayList<>();
        this.status = HttpStatus.OK;
    }
    public ValidResponse(String message, HttpStatus status, DateEntity date){
        this.errorMessages = new ArrayList<>();
        errorMessages.add(message);
        this.status = status;
        this.date = date;
    }
    public ValidResponse(String message, HttpStatus status){
        this.errorMessages = new ArrayList<>();
        errorMessages.add(message);
        this.status = status;

    }

    public void addErrorMessage(String errorMessage) {
        this.errorMessages.add(errorMessage);
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    public HttpStatus getStatus() {
        return status;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setDate(DateEntity date){ this.date = date;}

    public DateEntity getDate() {
        return this.date;
    }
}
