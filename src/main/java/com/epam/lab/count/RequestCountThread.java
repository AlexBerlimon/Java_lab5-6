package com.epam.lab.count;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RequestCountThread extends Thread{
    Logger logger = LogManager.getLogger(RequestCountThread.class);

    public RequestCountThread(){start();}
    @Override
    public void run(){
        try{
            logger.info(Thread.currentThread().getName()+" wait...");
            Synch.semaphore.acquire();
            RequestCount.inc();
            logger.info("Count = " + RequestCount.getCounter());

        }catch (InterruptedException e){
            logger.error("Thread was interrupted");
        }
        Synch.semaphore.release();
    }

}
