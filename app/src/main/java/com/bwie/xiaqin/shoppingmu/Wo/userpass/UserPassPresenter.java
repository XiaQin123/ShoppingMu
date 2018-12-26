package com.bwie.xiaqin.shoppingmu.Wo.userpass;

import com.bwie.xiaqin.shoppingmu.bean.RrgisterBean;
import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/12/17.
 */

public class UserPassPresenter {
    private UserPassView uv;
    private UserPassModel model;
    public void attach(UserPassView uv){
        this.uv = uv;
        model = new UserPassModel();
    }
    public void getUserPwd(String yPas,String xPas){
        Type type = new TypeToken<RrgisterBean>() {
        }.getType();
        model.getData(yPas, xPas, new ICallBack() {
            @Override
            public void onSuccess(Object o) {
                RrgisterBean data = (RrgisterBean) o;
                if (data != null){
                    uv.success(data);
                }
            }

            @Override
            public void onFailed(Exception e) {
                uv.onfailed(e);
            }
        },type);
    }
    public void onDestroy(){
        if (uv != null){
            uv = null;
        }
    }
}
