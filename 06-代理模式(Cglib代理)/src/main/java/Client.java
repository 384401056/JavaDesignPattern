import java.lang.reflect.Proxy;

/**
 * 动态代理，其中的代理角色由Proxy方法生成。
 *
 */
public class Client {

	public static void main(String[] args) {
		Star star = new Star();

		Star proxy = (Star) new ProxyFactory(star).getProxyInstance();

		String str = proxy.confer();
		System.out.println(str);

		proxy.sing();

		proxy.talk("Ha hah ha ");
	}

}
