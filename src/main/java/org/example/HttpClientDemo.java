package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientDemo {

    public static void main(String[] args) throws Exception {
        // 创建HttpClient实例
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 创建HttpGet请求
            HttpGet httpGet = new HttpGet("http://cms.cyngame.cn:8190/initAction/initLoadTable.action?actions=addAdvertScriptConfigValues&methodName=AdvertJoinSDK_ReCreate&formValue=%7B%22asId%22%3A%22203833%2C9483%2C5717%2C3018%22%2C%22key%22%3A%22VTO%22%2C%22value%22%3A%2277777%22%2C%22cId%22%3A157889%7D");

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

                    // 这里可以根据需要添加更详细的断言来验证响应内容
                    // 例如，使用JSON解析库来验证返回的JSON数据
                } else {
                    System.out.println("Request failed with status code: " + statusCode);
                }
            }
        }
    }
}
