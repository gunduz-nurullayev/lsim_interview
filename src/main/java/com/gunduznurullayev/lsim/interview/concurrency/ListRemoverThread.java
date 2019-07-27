package com.gunduznurullayev.lsim.interview.concurrency;

import com.gunduznurullayev.lsim.interview.utils.ListWrapper;
import org.apache.log4j.Logger;


public class ListRemoverThread extends Thread {

    static final Logger log = Logger.getLogger(ListRemoverThread.class);


    @Override
    public void run() {
        log.info("Remover thread is started");
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int element = ListWrapper.delete();
            if (element == -1) {
                log.warn("List is empty now");
            } else {
                log.info(element + " removed from list");
            }
        }
    }
}
