package com.bwie.xiaqin.shoppingmu.mvp.SearchSou.model;

import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.bwie.xiaqin.shoppingmu.utils.HttpUtils;
import com.bwie.xiaqin.shoppingmu.utils.SearchHttpUtils;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/12/14.
 */

public class SearchModel {
    public void getSearch(String url, ICallBack callBack, Type type){
        SearchHttpUtils.getInstance().get(url,callBack,type);
    }
}
