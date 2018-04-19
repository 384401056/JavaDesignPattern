import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerTask implements Runnable{

    private Socket socket;

    public ServerTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = "";

            //读取数据的方法是阻塞的。
            while ((line=br.readLine())!=null) {//按行读，意味着客户端发送的数据要有回车符，才会停止。
                try {
                    Class Clazz = Class.forName(line);  //通过class全名来获取类。
                    ServerAPI obj = (ServerAPI)Clazz.newInstance();  //根据类来创建一个类的实例，并且会调用类的无参构造方法，没有无参数构造会报错。
                    String result = obj.getData("Kings Man");
                    System.out.println(result);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
