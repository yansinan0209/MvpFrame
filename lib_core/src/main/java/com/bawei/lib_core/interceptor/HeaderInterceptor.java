package com.bawei.lib_core.interceptor;

import com.bawei.lib_core.utils.SpUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        //请求对象，原始请求对象，用户名密码
        Request request = chain.request();

        Request.Builder builder = request.newBuilder();

        builder.addHeader("userId", SpUtils.getInstance().getSp("userId"));
        builder.addHeader("sessionId",SpUtils.getInstance().getSp("sessionId"));
        //修改过的request对象
        Request nrequest = builder.build();

        //响应对象
        Response response = chain.proceed(nrequest);
        return response;
    }
}
