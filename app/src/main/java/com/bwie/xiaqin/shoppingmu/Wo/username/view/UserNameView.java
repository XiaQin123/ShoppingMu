package com.bwie.xiaqin.shoppingmu.Wo.username.view;

import com.bwie.xiaqin.shoppingmu.bean.RrgisterBean;

/**
 * Created by lenovo on 2018/12/17.
 */

public interface UserNameView {
    void success(RrgisterBean data);

    void failed(Exception e);
}
