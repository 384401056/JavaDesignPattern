package com.demao;


import java.lang.reflect.Constructor;

public class App {

    public static void main(String[] arg) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        Class Clazz = null;
        String className = "com.demao.Dog";
        Clazz = Class.forName(className);  //通过class全名来获取类。

        System.out.println(Clazz.getField("name")); //获取类的字段名（必须是public）
        System.out.println(Clazz.getMethod("run")); //获取类的方法名（必须是public）

        Object obj = Clazz.newInstance();  //根据类来创建一个类的实例，并且会调用类的无参构造方法，没有无参数构造会报错。
        System.out.println(obj);

        Constructor constructor = Clazz.getConstructor();  //获取构造函数本身
        System.out.println(constructor);

    }
}
