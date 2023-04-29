package com.epam.lab.counter;

import com.epam.lab.count.RequestResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RequestResponceTest {
    @Test
    public void ResponseTest(){
        RequestResponse requestResponse = new RequestResponse();
        requestResponse.setReponseMessage("size");
        requestResponse.setCount(2);

        Assertions.assertEquals("size", requestResponse.getResponseMessage());
        Assertions.assertEquals(2, requestResponse.getCount());
    }
}
