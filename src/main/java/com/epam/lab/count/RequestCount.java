package com.epam.lab.count;

public class RequestCount {
    private static int counter = 0;

    public static void inc(){
        counter++;
    }
    public static Integer getCounter() {
        return counter;
    }
}
