package com.bwie.xiaqin.shoppingmu.mvp.presenter.quan;


import com.bwie.xiaqin.shoppingmu.bean.QuanBean;
import com.bwie.xiaqin.shoppingmu.mvp.model.quan.QuanModel;
import com.bwie.xiaqin.shoppingmu.mvp.view.quan.QuanIView;
import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/12/12.
 */

public class QuanPresenter {
    private QuanIView iv;
    private QuanModel model;
    public void attach(QuanIView iv){
        this.iv = iv;
        model= new QuanModel();
    }
    public void get(){
        Type type = new TypeToken<QuanBean>(){}.getType();
        model.getData("http://172.17.8.100/small/circle/v1/findCircleList?userId=1010&sessionId=15320748258726&page=1&count=5\n", new ICallBack() {
            @Override
            public void onSuccess(Object o) {
                QuanBean Bean = (QuanBean) o;
                if (Bean!=null){
                    iv.onSuccess(Bean.getResult());
                }
            }

            @Override
            public void onFailed(Exception e) {
                iv.onFailed(e);
            }
        },type);
    }
    public void detach(){
        if (iv!=null){
            iv = null;
        }
    }
}
