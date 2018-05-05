package com.demo.jvmtest;

import java.util.ArrayList;


/**
 * 演示堆内存溢出
 * 通过run configuration 配置下列JVM参数.
 * VM agrs: -Xms20m -Xmx20m -XX:+HeapDumpOnOutofMemoryError -XX:HeapDumpPath=c:/dump
 * 参数-XX:+HeapDumpOnOutofMemoryError -XX:HeapDumpPath=c:/dump是指：当堆溢出后，将堆内存的快照转存(dump)到外部文件中。
 */
public class HeapOOM {

    static class OOMObject{
        public byte[] placeholder = new byte[1028 * 32];
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
