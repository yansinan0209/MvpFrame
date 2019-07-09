package com.bawei.lib_core.net;

public interface OkhttpCallback {

    //服务器请求失败：断网，服务器宕机等等因素
    void failure(String msg);

    //数据合法
    void success(String result);
}
