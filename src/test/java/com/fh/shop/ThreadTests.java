package com.fh.shop;

import com.fh.common.CountThread;

public class ThreadTests {

    public static void main(String[] args) {
        CountThread target = new CountThread();
        for(int i=0; i<500; i++){
            Thread thread = new Thread(target);
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(target.count);
    }
}
