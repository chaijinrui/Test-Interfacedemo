import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class GetHttpResponseHeader {
    public static void main(String[] args) throws Exception {
        // 目标URL
        String urlStr = "http://cms.cyngame.cn:8190/login/login.action?UserName=sns_cjr&PassWord=123456";

        // 创建URL对象
        URL url = new URL(urlStr);

        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // 设置请求方法，默认是GET
        connection.setRequestMethod("GET");

        // 发送请求
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        // 获取所有响应头字段
        Map<String, List<String>> headerFields = connection.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value(s): " + entry.getValue());
        }

        // 关闭连接
        connection.disconnect();
    }
}