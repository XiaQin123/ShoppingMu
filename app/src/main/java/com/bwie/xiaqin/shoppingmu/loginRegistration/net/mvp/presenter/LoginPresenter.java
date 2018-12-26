package com.bwie.xiaqin.shoppingmu.loginRegistration.net.mvp.presenter;

import com.bwie.xiaqin.shoppingmu.bean.LoginBean;
import com.bwie.xiaqin.shoppingmu.loginRegistration.net.mvp.model.LoginModel;
import com.bwie.xiaqin.shoppingmu.loginRegistration.net.mvp.view.LoginView;
import com.bwie.xiaqin.shoppingmu.loginRegistration.net.net.HttpCallback;

/**
 * Created by lenovo on 2018/12/8.
 */

public class LoginPresenter {
    private LoginModel login_model;
    private LoginView login_view;

    public LoginPresenter(LoginView login_view) {
        this.login_view = login_view;
        login_model = new LoginModel();
    }

    public void login(String phone, String pwd) {
        login_model.login(phone, pwd, new HttpCallback() {
            @Override
            public void OnSuccess(Object result) {
                LoginBean data = (LoginBean) result;

                login_view.OnSuccess(data);
            }

            @Override
            public void OnFaile(String msg) {
                login_view.OnFaile(msg);
            }
        });
    }
    public void onDestroy() {
        if (login_view != null) {
            login_view = null;
        }
    }

}
