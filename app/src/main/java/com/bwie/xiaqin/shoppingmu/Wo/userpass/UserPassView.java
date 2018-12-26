package com.bwie.xiaqin.shoppingmu.Wo.userpass;

import com.bwie.xiaqin.shoppingmu.bean.RrgisterBean;

/**
 * Created by lenovo on 2018/12/17.
 */

public interface UserPassView {
    void success(RrgisterBean data);

    void onfailed(Exception e);
}
