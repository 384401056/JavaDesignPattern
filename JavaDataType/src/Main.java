import java.util.*;

public class Main {

    public static void main(String[] args) {

        /**
         * 数据类型的最大值和最小值。
         */
//        System.out.println("Byte Max:"+Byte.MAX_VALUE);
//        System.out.println("Byte MIN:"+Byte.MIN_VALUE);
//
//        System.out.println("Short Max:"+Short.MAX_VALUE);
//        System.out.println("Short MIN:"+Short.MIN_VALUE);
//
//        System.out.println("Integer Max:"+Integer.MAX_VALUE);
//        System.out.println("Integer MIN:"+Integer.MIN_VALUE);
//
//        System.out.println("Float Max:"+Float.MAX_VALUE);
//        System.out.println("Float MIN:"+Float.MIN_VALUE);
//
//        System.out.println("Long Max:"+Long.MAX_VALUE);
//        System.out.println("Long MIN:"+Long.MIN_VALUE);
//
//        System.out.println("Double Max:"+Double.MAX_VALUE);
//        System.out.println("Double MIN:"+Double.MIN_VALUE);

//        int a[] = new int[10];
//        int b[] = {1,2,3,5,6,7};
//
//        System.out.println(a.length);
//        System.out.println(b.length);

        /**
         * 有序列表的自定义排序。
         */
//        Person a = new Person();
//        Person b = new Person();
//        Person c = new Person();
//        a.age = 10;
//        a.name = "张三";
//        b.age = 20;
//        b.name = "李四";
//        c.age = 30;
//        c.name = "王五";
//
//        TreeSet ts = new TreeSet();
//        ts.add(a);
//        ts.add(b);
//        ts.add(c);
//        System.out.println(ts);

        /**
         * Queue
         */
//        Queue qu = new LinkedList();
//        qu.add("李小璐");
//        qu.add("贾乃亮");
//        qu.add("甜馨");
//
//        System.out.println(qu.poll());//先进先出
//        System.out.println(qu);

        /**
         * 迭代器的使用
         */
//        List mylist = new ArrayList();
//        mylist.add("张三");
//        mylist.add("李四");
//        mylist.add("王五");
//
//        //while循环的格式写法。
//        Iterator iterator = mylist.iterator();
//        while (iterator.hasNext()){
//            String str = (String) iterator.next();
//            System.out.println(str);
//        }
//
//        //for循环的格式写法。
//        for(Iterator iter = mylist.iterator();iter.hasNext();){
//            String str = (String) iter.next();
//            System.out.println(str);
//        }


        /**
         * 异常处理
         */
//        try {
//            throwChecked(10);
//        } catch (Exception ex) {
//            System.out.println("上层处理" + ex.getMessage());
//        }
//
//        try {
//            throwRuntime(20);
//        } catch (Exception ex) {
//            System.out.println("上层处理" + ex.getMessage());
//        }


    }


    public static void throwChecked(int a) throws Exception {
        if (a > 0) {
            throw new RuntimeException("第一种异常");
        }
    }

    public static void throwRuntime(int a) {
        if (a > 0) {
            throw new RuntimeException("第二种异常");
        }
    }
}

class Person implements Comparable {
    String name;
    int age;

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        if (this.age < p.age) {
            return -1;
        } else if (this.age > p.age) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
