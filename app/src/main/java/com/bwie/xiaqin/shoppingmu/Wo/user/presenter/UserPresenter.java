package com.bwie.xiaqin.shoppingmu.Wo.user.presenter;

import com.bwie.xiaqin.shoppingmu.Wo.user.model.UserModel;
import com.bwie.xiaqin.shoppingmu.Wo.user.view.UserView;
import com.bwie.xiaqin.shoppingmu.bean.UserBean;
import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/12/17.
 */

public class UserPresenter {
    private UserView uv;
    private UserModel model;
    public void attach(UserView uv){
        this.uv = uv;
        model = new UserModel();
    }
    public void getUser(){
        Type type = new TypeToken<UserBean>() {
        }.getType();
        model.getData(new ICallBack() {
            @Override
            public void onSuccess(Object o) {
                UserBean list = (UserBean) o;
                if (list != null){
                    uv.successful(list);
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
