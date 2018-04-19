import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBoss {

    public static <T> T getProxy(final int disconutCoupon,
                                 final Class<?> interfaceClass,
                                 final Class<?> implementsClass) {

        //返回指定接口的代理类的实例
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class[]{interfaceClass},
                new InvocationHandler() {
                    /**
                     *
                     * @param proxy 代理对象。
                     * @param method 要执行的方法。
                     * @param args 传入的参数。
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //调用原始对象的方法返回的值。
                        Integer returnValue = (Integer) method.invoke(implementsClass.newInstance(), args);
                        //新返回的值。
                        return returnValue - disconutCoupon;
                    }
                });

    }
}
