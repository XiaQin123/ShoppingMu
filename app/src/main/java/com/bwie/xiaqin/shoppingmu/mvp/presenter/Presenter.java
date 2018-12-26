package com.bwie.xiaqin.shoppingmu.mvp.presenter;

import com.bwie.xiaqin.shoppingmu.bean.Prouduct;
import com.bwie.xiaqin.shoppingmu.mvp.model.home.Model;
import com.bwie.xiaqin.shoppingmu.mvp.view.IView;
import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/12/6.
 */

public class Presenter {
    private IView iv;
    private Model model;
    public void attach(IView iv){
        this.iv = iv;
        model = new Model();
    }
    public void getRxData(){
        String url = "http://172.17.8.100/small/commodity/v1/commodityList";
        Type type = new TypeToken<Prouduct>() {
        }.getType();
        model.getData(url, new ICallBack() {
            @Override
            public void onSuccess(Object o) {
                Prouduct list = (Prouduct) o;
                if (list != null){
                    iv.getRxData(list.getResult().getRxxp().get(0).getCommodityList());
                }
            }

            @Override
            public void onFailed(Exception e) {
                iv.onFailed(e);
            }
        },type);
    }
    public void getMxData(){
        String url = "http://172.17.8.100/small/commodity/v1/commodityList";
        Type type = new TypeToken<Prouduct>() {
        }.getType();
        model.getData(url, new ICallBack() {
            @Override
            public void onSuccess(Object o) {
                Prouduct list = (Prouduct) o;
                if (list != null){
                    iv.getMxData(list.getResult().getMlss().get(0).getCommodityList());
                }
            }

            @Override
            public void onFailed(Exception e) {
                iv.onFailed(e);
            }
        },type);
    }
    public void getPzData(){
        String url = "http://172.17.8.100/small/commodity/v1/commodityList";
        Type type = new TypeToken<Prouduct>() {
        }.getType();
        model.getData(url, new ICallBack() {
            @Override
            public void onSuccess(Object o) {
                Prouduct list = (Prouduct) o;
                if (list != null){
                    iv.getPzData(list.getResult().getPzsh().get(0).getCommodityList());
                }
            }

            @Override
            public void onFailed(Exception e) {
                iv.onFailed(e);
            }
        },type);
    }
    public void detach(){
        if (iv != null){
            iv = null;
        }
    }
}
