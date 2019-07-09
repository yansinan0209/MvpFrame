package com.bawei.mvpframe.model;

import com.bawei.lib_network.bean.BaseResponseBean;
import com.bawei.lib_network.network.HttpObserver;
import com.bawei.lib_network.network.RetrofitUtils;
import com.bawei.lib_network.network.RxUtils;
import com.bawei.mvpframe.api.HomeApiService;
import com.bawei.mvpframe.contract.HomeContract;
import com.bawei.mvpframe.entity.HomeBean;

import java.util.HashMap;

public class HomeModel implements HomeContract.IHomeModel {

    @Override
    public void getProductList(HashMap<String, String> params, final IProductCallback callback) {

        RetrofitUtils.getInstance().createService(HomeApiService.class)
                .getProducts(params)
                .compose(RxUtils.<BaseResponseBean<HomeBean.Product>>schdulers())
                .subscribe(new HttpObserver<BaseResponseBean<HomeBean.Product>>() {
                    @Override
                    public void onSuccess(BaseResponseBean<HomeBean.Product> response) {
                        if (callback!=null){
                            callback.success(response.result);
                        }
                    }
                });


    }

    public interface IProductCallback{
        public void failure(String msg);

        public void success(HomeBean.Product result);
    }
}
