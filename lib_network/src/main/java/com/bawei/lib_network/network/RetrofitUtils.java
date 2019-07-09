package com.bawei.lib_network.network;

import com.bawei.lib_network.api.ApiService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * regrofit工具类
 */
public class RetrofitUtils {
    private static volatile RetrofitUtils mInstance;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    private RetrofitUtils() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(httpLoggingInterceptor)
                .addInterceptor(new HeaderInterceptor())//头部拦截器
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    public static RetrofitUtils getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitUtils.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitUtils();
                }
            }
        }

        return mInstance;
    }

    /**
     * 动态代理模式，创建请求接口类
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T createService(Class<T> tClass){

        return retrofit.create(tClass);
    }


}
