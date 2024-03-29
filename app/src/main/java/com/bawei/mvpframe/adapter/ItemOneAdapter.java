package com.bawei.mvpframe.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.mvpframe.entity.HomeBean;
import com.bumptech.glide.Glide;

import java.util.List;

public class ItemOneAdapter extends RecyclerView.Adapter<ItemOneAdapter.MyVh> {
    private Context context;
    private List<HomeBean.ProductItemBean.ProductItem> commodityList ;
    public ItemOneAdapter(Context context,List<HomeBean.ProductItemBean.ProductItem> commodityList) {
        this.commodityList = commodityList;
        this.context =context;
    }

    @NonNull
    @Override
    public MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemone_layout,viewGroup,false);
        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVh myVh, int position) {

        myVh.titleTv.setText(commodityList.get(position).commodityName);
        Glide.with(context).load(commodityList.get(position).masterPic).into(myVh.iv);
        myVh.priceTv.setText("¥："+commodityList.get(position).price);

        if (position==commodityList.size()-1){
            myVh.view.setVisibility(View.GONE);
        }else{
            myVh.view.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return commodityList.size();
    }

    public class MyVh extends RecyclerView.ViewHolder{
        private TextView titleTv,priceTv;
        private RoundedImageView iv;
        private View view;
        public MyVh(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.tv);
            iv = itemView.findViewById(R.id.iv);
            priceTv = itemView.findViewById(R.id.price);
            view = itemView.findViewById(R.id.border);

        }
    }
}
