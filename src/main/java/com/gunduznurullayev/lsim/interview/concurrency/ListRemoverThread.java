package com.gunduznurullayev.lsim.interview.concurrency;

import com.gunduznurullayev.lsim.interview.utils.LimitExceedException;
import com.gunduznurullayev.lsim.interview.utils.ListWrapper;
import org.apache.log4j.Logger;


public class ListRemoverThread extends Thread {

    static final Logger log = Logger.getLogger(ListRemoverThread.class);
    private volatile boolean isActive = true;

    @Override
    public void run() {
        log.info("Remover thread is started");
        while (isActive) {
            try {
                Thread.sleep(500);
                int element = ListWrapper.delete();
                if (element == -1) {
                    log.warn("List is empty now");
                } else {
                    log.info(element + " removed from list");
                }
            } catch (InterruptedException | LimitExceedException e) {
                log.error(e.getMessage(), e);
                isActive = false;
            }
        }

    }
}
