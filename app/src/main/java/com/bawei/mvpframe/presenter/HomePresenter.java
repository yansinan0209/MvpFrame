package com.bawei.mvpframe.presenter;

import com.bawei.mvpframe.contract.HomeContract;
import com.bawei.mvpframe.entity.HomeBean;
import com.bawei.mvpframe.model.HomeModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomePresenter extends HomeContract.HomePresenter {


    @Override
    public void getProductList(HashMap<String, String> params) {
        model.getProductList(params, new HomeModel.IProductCallback() {
            @Override
            public void failure(String msg) {
                view.failure(msg);
            }

            @Override
            public void success(HomeBean.Product result) {
                    List<HomeBean.ProductItemBean> list = new ArrayList<>();

                    list.addAll(result.rxxp);//添加集合数据到当前集合内
                    list.addAll(result.pzsh);
                    list.addAll(result.mlss);

                    view.success(list);

            }
        });
    }

    /**
     * 商品详情接口
     * @param params
     */
    @Override
    public void getProductDetail(HashMap<String, String> params) {

    }
}
