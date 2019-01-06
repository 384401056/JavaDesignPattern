package com.proxy;

public class RealIStar implements IStar {
    @Override
    public void sing() {
        System.out.println("RealIStar(明星本人).sing()");
    }

    @Override
    public String confer() {
        System.out.println("RealIStar(明星本人).confer()");
        return "RealIStar(明星本人).confer()";
    }

    @Override
    public void talk(String msg) {
        System.out.println("msg:" + msg);
    }
}
