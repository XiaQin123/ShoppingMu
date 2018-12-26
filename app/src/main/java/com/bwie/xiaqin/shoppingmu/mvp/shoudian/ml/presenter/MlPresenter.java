package com.bwie.xiaqin.shoppingmu.mvp.shoudian.ml.presenter;

import com.bwie.xiaqin.shoppingmu.bean.MlBean;
import com.bwie.xiaqin.shoppingmu.mvp.shoudian.ml.model.MlModel;
import com.bwie.xiaqin.shoppingmu.mvp.shoudian.ml.view.MlView;
import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/12/14.
 */

public class MlPresenter {
    private MlModel model;
    private MlView ml;

    public void attach(MlView ml) {
        this.ml = ml;
        model = new MlModel();
    }

    public void getMl() {
        String url = "http://172.17.8.100/small/commodity/v1/findCommodityListByLabel?labelId=1003&page=1&count=10";
        Type type = new TypeToken<MlBean>() {
        }.getType();
        model.getData(url, new ICallBack() {
            @Override
            public void onSuccess(Object o) {
                MlBean list = (MlBean) o;
                if (list != null) {
                    ml.getMl(list.getResult());
                }
            }

            @Override
            public void onFailed(Exception e) {
                ml.onfailed(e);
            }

        }, type);
    }

    public void onDestroy() {
        if (ml != null) {
            ml = null;
        }
    }
}
