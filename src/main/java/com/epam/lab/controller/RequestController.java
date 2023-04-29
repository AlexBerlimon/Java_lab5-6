package com.epam.lab.controller;

import com.epam.lab.count.RequestCount;
import com.epam.lab.count.RequestResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    Logger logger = LogManager.getLogger(RequestController.class);
    @GetMapping(value="/api/lab/counter")
    public RequestResponse getRequestCount(){
        logger.info("Request Counter");
        return new RequestResponse("Count of Requests", RequestCount.getCounter());
    }
}
