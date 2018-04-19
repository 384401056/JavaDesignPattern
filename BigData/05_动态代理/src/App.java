public class App {

    public static void main(String[] args){
        //boss1的类型可以接口也可以是实现类。
        Boss boss1 = new Boss();
        System.out.println("老板自营.");
        int money1 = boss1.yifu("20");
        System.out.println("衣服成交价："+ money1);

        //创建代理对象，传入参数，接口类和实现类
        //同样和接口和方法，通过增加代理的形式，增强了原来接口中方法的功能,而且没有改正原来的接口类和实现类。
        //注意这里的boss2变量是接口类型。
        IBoss boss2 = ProxyBoss.getProxy(100,IBoss.class,Boss.class);
        System.out.println("代理经营.");
        int money2 = boss2.yifu("20");
        System.out.println("衣服成交价："+ money2);
    }
}
