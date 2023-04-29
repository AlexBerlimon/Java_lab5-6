package com.epam.lab.count;

public class RequestResponse {
    private int count;
    private String responseMessage;
    public RequestResponse(){
        this.count = 0;
        this.responseMessage = "";
    }
    public RequestResponse(String responseMessage, int count){
        this.count = count;
        this.responseMessage = responseMessage;
    }
    public int getCount() {return count; }
    public void setCount(int count) { this.count = count;}
    public String getResponseMessage() { return responseMessage;}
    public void setReponseMessage(String responseMessage){ this.responseMessage = responseMessage; }
}
