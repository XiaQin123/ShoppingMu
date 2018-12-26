package com.bwie.xiaqin.shoppingmu.mvp.shoudian.rx.model;

import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.bwie.xiaqin.shoppingmu.utils.HttpUtils;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/12/14.
 * 魔力的model
 */

public class RxModel {
    public void getData(String url, ICallBack callBack, Type type){
        HttpUtils.getInstance().get(url,callBack,type);
    }

}
