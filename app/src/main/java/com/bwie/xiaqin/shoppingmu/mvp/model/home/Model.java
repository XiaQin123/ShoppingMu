package com.bwie.xiaqin.shoppingmu.mvp.model.home;

import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.bwie.xiaqin.shoppingmu.utils.HttpUtils;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/12/6.
 */

public class Model {
    public void getData(String url, ICallBack callBack, Type type){
        HttpUtils.getInstance().get(url,callBack,type);
    }

}
