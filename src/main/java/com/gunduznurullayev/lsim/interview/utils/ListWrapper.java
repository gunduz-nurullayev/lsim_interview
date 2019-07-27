package com.gunduznurullayev.lsim.interview.utils;

import com.gunduznurullayev.lsim.interview.concurrency.ListWriterThread;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class ListWrapper {
    static final Logger log = Logger.getLogger(ListWrapper.class);
    private static final int MAX_SIZE = 100;
    private static ArrayList<Integer> data = new ArrayList<Integer>(MAX_SIZE);

    public static synchronized boolean add(int element) {
        if (size() < MAX_SIZE) {
            data.add(element);
            return true;
        }
        return false;
    }

    public static synchronized int size() {
        int size = data.size();
        log.info("size: " + size);
        if(size > 100) {
            throw new IllegalStateException("Size exceed " + size);
        }
        return size;
    }

    public static synchronized int delete() {
        int size = size();
        if (size > 0) {
            return data.remove(--size);
        }
        return -1;
    }
}
