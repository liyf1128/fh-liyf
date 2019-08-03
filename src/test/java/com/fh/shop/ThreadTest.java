package com.fh.shop;

import com.fh.common.CountThread;

public class ThreadTest {

    public static void main(String[] args) {
        CountThread target = new CountThread();
        Thread thread = new Thread(target);
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(target.count);
    }
}
