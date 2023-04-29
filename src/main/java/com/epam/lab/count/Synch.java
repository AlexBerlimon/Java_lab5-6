package com.epam.lab.count;

import org.springframework.stereotype.Component;

import java.util.concurrent.Semaphore;

@Component
public class Synch {
public final static Semaphore semaphore = new Semaphore(1, true);
}
