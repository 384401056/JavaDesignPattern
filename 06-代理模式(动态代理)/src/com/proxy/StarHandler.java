package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 处理器对象。
 * 1.通过invoke方法，实现对代理角色的真实访问。
 * 2.通过Proxy方法生成代理类对象时都要指定对应的处理器对象。
 */
public class StarHandler implements InvocationHandler {

    //真实对象的引用。
    private RealIStar realStar;

    public StarHandler(IStar realIStar) {
        super();
        this.realStar = (RealIStar) realIStar;
    }

    /**
     * 第一个参数是：代理对象。
     * 第二个参数是：正在调用的方法
     * 第三个参数时：方法参数。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        Object obj = null;


        if (method.getName().equals("confer")) {
            obj = method.invoke(realStar, args);//如果方法有返回值可以在这里接收，最后返回
        }

        if(method.getName().equals("talk")){
            System.out.println("args:"+ args[0].toString());
            method.invoke(realStar, args);
        }

        //如果调用的是唱歌的方法
        if (method.getName().equals("sing")) {
            System.out.println("=======唱歌前的操作=======");
            System.out.println("代理人面谈");
            System.out.println("代理人签合同");
            System.out.println("代理人定机票");
            method.invoke(realStar, args);
            //唱歌后的操作。
            System.out.println("========唱歌后的操作=======");
            System.out.println("代理人收尾款");
        }


        return obj;
    }


}
