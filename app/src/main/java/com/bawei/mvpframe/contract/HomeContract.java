package com.bawei.mvpframe.contract;

import com.bawei.lib_core.base.mvp.BasePresenter;
import com.bawei.lib_core.base.mvp.IBaseView;
import com.bawei.mvpframe.entity.HomeBean;
import com.bawei.mvpframe.model.HomeModel;

import java.util.HashMap;
import java.util.List;

/**
 * 商品相关契约类
 */
public interface HomeContract {

     abstract class HomePresenter extends BasePresenter<IHomeModel,IHomeView> {



        public abstract void getProductList(HashMap<String, String> params);
        public abstract void getProductDetail(HashMap<String, String> params);

         @Override
         public IHomeModel getModel() {
             return new HomeModel();
         }
     }

    interface IHomeModel extends IBaseModel{

        void getProductList(HashMap<String, String> params, HomeModel.IProductCallback callback);

    }

    interface IHomeView extends IBaseView {

        void success(List<HomeBean.ProductItemBean> list);
        void keywordsEmpty(String error);

    }
}
