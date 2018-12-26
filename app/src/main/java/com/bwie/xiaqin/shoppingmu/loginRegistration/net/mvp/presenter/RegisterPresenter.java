package com.bwie.xiaqin.shoppingmu.loginRegistration.net.mvp.presenter;

import com.bwie.xiaqin.shoppingmu.loginRegistration.net.mvp.model.RegisterModel;
import com.bwie.xiaqin.shoppingmu.loginRegistration.net.mvp.view.RegisterView;
import com.bwie.xiaqin.shoppingmu.loginRegistration.net.net.HttpCallBackRegister;

/**
 * Created by lenovo on 2018/12/8.
 */

public class RegisterPresenter {
    private RegisterView registerView;
    private RegisterModel registerModel;

    public RegisterPresenter(RegisterView registerView) {
        this.registerView = registerView;
        registerModel = new RegisterModel();
    }

    public void register(String phone, String pwd) {
        registerModel.register(phone, pwd, new HttpCallBackRegister() {
            @Override
            public void onSuccess(String data) {
                registerView.onSuccess(data);
            }

            @Override
            public void onFaile(String msg) {
                registerView.onFaile(msg);
            }
        });
    }

}
