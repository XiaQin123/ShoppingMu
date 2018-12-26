package com.bwie.xiaqin.shoppingmu.Wo.username.presenter;

import com.bwie.xiaqin.shoppingmu.Wo.username.model.UserNameModel;
import com.bwie.xiaqin.shoppingmu.Wo.username.view.UserNameView;
import com.bwie.xiaqin.shoppingmu.bean.RrgisterBean;
import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/12/17.
 */

public class UserNamePresenter {
    private UserNameView uv;
    private UserNameModel model;
    public void attach(UserNameView uv){
        this.uv = uv;
        model = new UserNameModel();
    }

    public void getUserName(String nickName){
        Type type = new TypeToken<RrgisterBean>() {
        }.getType();
        model.getData(nickName, new ICallBack() {
            @Override
            public void onSuccess(Object o) {
                RrgisterBean list = (RrgisterBean) o;
                if (list != null){
                    uv.success(list);
                }
            }

            @Override
            public void onFailed(Exception e) {
                uv.failed(e);
            }
        },type);
    }
    public void onDestroy(){
        if (uv != null){
            uv = null;
        }
    }
}
