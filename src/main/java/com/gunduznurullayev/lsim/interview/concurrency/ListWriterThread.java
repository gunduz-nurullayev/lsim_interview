package com.gunduznurullayev.lsim.interview.concurrency;

import com.gunduznurullayev.lsim.interview.utils.ListWrapper;
import org.apache.log4j.Logger;
import java.util.concurrent.atomic.AtomicInteger;

public class ListWriterThread extends Thread {
    static final Logger log = Logger.getLogger(ListWriterThread.class);

    private static AtomicInteger COUNTER = new AtomicInteger(0);

    @Override
    public void run() {
        log.info("Writer thread is started");

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(COUNTER.intValue() == Integer.MAX_VALUE) {
                log.warn("Integer value is maximum");
                COUNTER.set(0);
            }
            if (ListWrapper.add(COUNTER.getAndIncrement())) {
                log.info(COUNTER.get() + " added to list");
            } else {
                log.warn("List exceeds the limit, 5 seconds wait for adding new element");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
