package com.bawei.mvpframe.api;

import com.bawei.lib_network.bean.BaseResponseBean;
import com.bawei.mvpframe.entity.HomeBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface HomeApiService {

    @GET("commodity/v1/commodityList")
    Observable<BaseResponseBean<HomeBean.Product>> getProducts(@QueryMap HashMap<String, String> parms);
}
