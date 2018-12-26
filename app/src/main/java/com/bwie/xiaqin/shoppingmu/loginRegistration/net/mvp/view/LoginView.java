package com.bwie.xiaqin.shoppingmu.loginRegistration.net.mvp.view;

import com.bwie.xiaqin.shoppingmu.bean.LoginBean;

/**
 * Created by lenovo on 2018/12/8.
 */

public interface LoginView {
    void OnSuccess(LoginBean result);

    void OnFaile(String msg);
}
