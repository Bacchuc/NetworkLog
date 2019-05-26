package com.bacchus.networkloglib.interceptor;

import androidx.annotation.NonNull;

import com.bacchus.networkloglib.bean.NetWorkLogInfo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Set;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * NetworkLog明文的拦截器
 */
public class NetworkLogInterceptor implements Interceptor {


    private static final String CHARSET = "UTF-8";

    @NonNull
    private String action;

    public NetworkLogInterceptor(@NonNull String action) {
        this.action = action;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        // 创建一个日志数据包,未加密
        NetWorkLogInfo clearNetWorkLogInfo = new NetWorkLogInfo();

        long startTime = System.currentTimeMillis();
        String responseError = null;

        try {

            // 拿到请求对象
            Request request = chain.request();

            // 记录请求
            readRequestInfo(request, clearNetWorkLogInfo);

            // 执行请求
            Response response = chain.proceed(chain.request());

            // 记录响应
            response = readResponseInfo(response, clearNetWorkLogInfo);

            return response;

        } catch (Exception e) {
            responseError = "errorMsg：" + e.getMessage();
            throw e;
        } finally {

            if (responseError != null) { // 不然会覆盖原有的信息
                // 设置 responseMsg
                clearNetWorkLogInfo.setRes_body(responseError);
            }

            long endTime = System.currentTimeMillis();
            long timeConsumed = endTime - startTime;

            clearNetWorkLogInfo.getReq_headers().add("Time Consumed: " + timeConsumed);

            // TODO 发送到浏览器
//            LogServer.getInstance().sendNetworkData(action, clearNetWorkLogInfo);

        }

    }

    public static void readRequestInfo(@NonNull Request request, @NonNull NetWorkLogInfo info) {

        String url = request.url().toString();

        info.setReq_method(request.method());

        info.setReq_url(url);
        Headers headers = request.headers();
        info.getReq_headers().clear();
        if (headers != null) {
            Set<String> names = headers.names();
            if (names != null) {
                for (String name : names) {
                    String headerValue = headers.get(name);
                    info.getReq_headers().add(name + ": " + headerValue);
                }
            }
        }

        info.getReq_headers().add("Network: retrofit");

        try {
            RequestBody requestBody = request.body();
            if (requestBody != null) {
                Buffer bufferedSink = new Buffer();
                requestBody.writeTo(bufferedSink);
                info.setReq_body(bufferedSink.readString(Charset.forName(CHARSET)));
            }
        } catch (Exception ignore) {
            // ignore
        }

    }

    public static Response readResponseInfo(@NonNull Response response, @NonNull NetWorkLogInfo info) throws IOException {

        info.setRes_code(response.code());
        info.setRes_message(response.message());
        Headers headers = response.headers();
        info.getRes_headers().clear();
        if (headers != null) {
            Set<String> names = headers.names();
            if (names != null) {
                for (String name : names) {
                    String headerValue = headers.get(name);
                    info.getRes_headers().add(name + ": " + headerValue);
                }
            }
        }

        ResponseBody resultResponseBody = null;

        ResponseBody responseBody = response.body();
        info.setRes_body(responseBody.string());
        resultResponseBody = ResponseBody.create(response.body().contentType(), info.getRes_body());

        return response.newBuilder().body(resultResponseBody).build();

    }


}
