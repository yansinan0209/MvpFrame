package com.bawei.mvpframe;

import android.support.v7.widget.LinearLayoutManager;
import com.bawei.lib_core.base.mvp.BaseMvpActivity;
import com.bawei.lib_core.base.mvp.BasePresenter;
import com.bawei.mvpframe.adapter.HomeAdapter;
import com.bawei.mvpframe.contract.HomeContract;
import com.bawei.mvpframe.entity.HomeBean;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<HomeContract.IHomeModel, HomeContract.HomePresenter> implements HomeContract.IHomeView {


    @BindView(R.id.rv)
    XRecyclerView rv;

    @Override
    protected void initView() {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void success(List<HomeBean.ProductItemBean> productBean) {

        HomeAdapter productAdapter = new HomeAdapter(productBean,this);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(productAdapter);

    }

    @Override
    public void keywordsEmpty(String error) {
        showToast(error);

    }

    @Override
    public BasePresenter initPresenter() {
        return new HomeContract.HomePresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void failure(String msg) {

        showToast(msg);

    }


    /**
     * 初始化数据
     */
    @Override
    protected void init() {
        HashMap<String,String> params = new HashMap<>();
        params.put("keyword","电脑");
        params.put("page","1");
        params.put("count","10");
        presenter.getProductList(params);
    }
}
