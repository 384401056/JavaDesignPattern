import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://www.baidu.com");

        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            byte[] date = EntityUtils.toByteArray(entity);
            System.out.println(new String(date,"UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
