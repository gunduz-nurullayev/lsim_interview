package com.gunduznurullayev.lsim.interview;

import com.gunduznurullayev.lsim.interview.concurrency.ListRemoverThread;
import com.gunduznurullayev.lsim.interview.concurrency.ListWriterThread;
import org.apache.log4j.PropertyConfigurator;

public class Main {

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        Thread thread1 = new Thread(new ListWriterThread());
        Thread thread2 = new Thread(new ListRemoverThread());
        thread1.start();
        thread2.start();

    }
}
