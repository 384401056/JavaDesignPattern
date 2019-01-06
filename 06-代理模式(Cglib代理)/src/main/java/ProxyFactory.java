import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

    //目标对象
    private Object realStar;

    public ProxyFactory(Object realStar) {
        this.realStar = realStar;
    }

    // 给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(realStar.getClass());

        //3.设置回调函数,ProxyFactory
        en.setCallback(this);

        //4.创建子类(代理对象)
        return en.create();

    }

    /**
     * 第一个参数是：代理对象。
     * 第二个参数是：正在调用的方法
     * 第三个参数时：方法参数。
     */
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
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
