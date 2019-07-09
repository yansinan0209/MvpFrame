package com.bawei.lib_network.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 头部拦截器
 */
public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        //原始请求对象
        Request originalRequest = chain.request();

        Request nrequest = originalRequest.newBuilder()
                .addHeader("userId","270")
                .addHeader("sessionId","1550566757244270")
                .build();

        Response response = chain.proceed(nrequest);

        return response;
    }
}
