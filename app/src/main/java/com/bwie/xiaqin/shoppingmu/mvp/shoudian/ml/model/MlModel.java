package com.bwie.xiaqin.shoppingmu.mvp.shoudian.ml.model;

import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.bwie.xiaqin.shoppingmu.utils.HttpUtils;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/12/14.
 */

public class MlModel {
    public void getData(String url, ICallBack iNetCallBack, Type type){
        HttpUtils.getInstance().get(url, iNetCallBack, type);
    }
}
