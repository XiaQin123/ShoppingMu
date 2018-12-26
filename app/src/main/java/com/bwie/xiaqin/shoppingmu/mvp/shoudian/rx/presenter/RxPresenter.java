package com.bwie.xiaqin.shoppingmu.mvp.shoudian.rx.presenter;

import com.bwie.xiaqin.shoppingmu.bean.RxBean;
import com.bwie.xiaqin.shoppingmu.mvp.shoudian.rx.model.RxModel;
import com.bwie.xiaqin.shoppingmu.mvp.shoudian.rx.view.RxView;
import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/12/14.
 */

public class RxPresenter {
    private RxModel model;
    private RxView rv;
    public void attach(RxView rv){
        model = new RxModel();
        this.rv = rv;
    }
    public void getRx(){
        String url = "http://172.17.8.100/small/commodity/v1/findCommodityListByLabel?labelId=1002&&page=1&&count=10";
        Type type = new TypeToken<RxBean>(){}.getType();
        model.getData(url, new ICallBack() {
            @Override
            public void onSuccess(Object o) {
                RxBean list = (RxBean) o;
                if (list!=null){
                    rv.getRx(list.getResult());
                }
            }

            @Override
            public void onFailed(Exception e) {
                rv.onfailed(e);
            }
        },type);
    }
    public void onDestroy(){
        if (rv!=null){
            rv = null;
        }
    }
}
