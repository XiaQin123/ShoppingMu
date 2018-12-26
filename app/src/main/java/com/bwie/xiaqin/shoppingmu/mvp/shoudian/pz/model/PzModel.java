package com.bwie.xiaqin.shoppingmu.mvp.shoudian.pz.model;

import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.bwie.xiaqin.shoppingmu.utils.HttpUtils;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/12/14.
 */

public class PzModel {
    public void getData(String url, ICallBack iNetCallBack, Type type){
        HttpUtils.getInstance().get(url, iNetCallBack, type);
    }
}
