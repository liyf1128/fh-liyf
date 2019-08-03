package com.fh.common;

public class CountThread implements Runnable{

    public int count = 0;
    @Override
    public void run() {
        add();
    }

    public void add(){
        count++;
    }
}
