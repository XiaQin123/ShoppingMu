package com.bwie.xiaqin.shoppingmu.mvp.shoudian.pz.presenter;

import com.bwie.xiaqin.shoppingmu.bean.PzBean;
import com.bwie.xiaqin.shoppingmu.mvp.shoudian.pz.model.PzModel;
import com.bwie.xiaqin.shoppingmu.mvp.shoudian.pz.view.PzView;
import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/12/14.
 */

public class PzPresenter {
    private PzView pz;
    private PzModel model;
    public void attach(PzView pz){
        this.pz = pz;
        model = new PzModel();
    }
    public void getPz(){
        String url = "http://172.17.8.100/small/commodity/v1/findCommodityListByLabel?labelId=1004&page=1&count=10";
        Type type = new TypeToken<PzBean>() {
        }.getType();
        model.getData(url, new ICallBack() {
            @Override
            public void onSuccess(Object o) {
                PzBean list = (PzBean) o;
                if (list != null){
                    pz.getRx(list.getResult());
                }
            }

            @Override
            public void onFailed(Exception e) {
                pz.onfailed(e);
            }
        },type);
    }
    public void onDestroy(){
        if (pz != null){
            pz = null;
        }
    }
}
