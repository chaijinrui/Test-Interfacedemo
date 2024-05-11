
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URL;

public class TestRequest {

    public static void main(String[] args) throws Exception {
        // 创建HttpClient实例
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 创建HttpGet请求

            String url = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?actions=addAdvertScriptConfigValues&methodName=AdvertJoinSDK_ReCreate&formValue={\"asId\":\"203833,9483,5717,3018\",\"key\":\"VTO\",\"value\":\"666\",\"cId\":157889}";
            HttpGet httpGet = new HttpGet(url);

            // 设置请求头（可选），比如添加认证信息
            httpGet.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");

            // 执行请求
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                // 获取响应状态码
                int statusCode = response.getStatusLine().getStatusCode();
                System.out.println("Response Status Code: " + statusCode);

                // 检查响应状态码是否为200
                if (statusCode == 200) {
                    // 获取响应实体
                    HttpEntity entity = response.getEntity();

                    // 将实体转换为字符串
                    String responseBody = EntityUtils.toString(entity);

                    // 输出响应内容
                    System.out.println("Response Body: " + responseBody);

                    System.out.println(responseBody.getClass());

                    // 这里可以根据需要添加更详细的断言来验证响应内容
                    // 例如，使用JSON解析库来验证返回的JSON数据
                } else {
                    System.out.println("Request failed with status code: " + statusCode);
                }
            }
        }
    }
}