package com.demo.jvmtest;

import java.util.ArrayList;

public class TestMemory {

    static class OOMObject{
        public byte[] placeholder = new byte[1028 * 64 * 40];
    }

    /**
     * 填充堆
     * @param num
     */
    public static void fillHeap(int num) throws InterruptedException {
        ArrayList<OOMObject> list = new ArrayList<OOMObject>();
        for (int i=0; i<num; i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
    }


    public static void main(String[] arg) throws InterruptedException {
        Thread.sleep(1000);
        fillHeap(100);
        System.gc();
    }

}
