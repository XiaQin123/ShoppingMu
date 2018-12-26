package com.bwie.xiaqin.shoppingmu.Wo.user.view;

import com.bwie.xiaqin.shoppingmu.bean.UserBean;

/**
 * Created by lenovo on 2018/12/17.
 */

public interface UserView {
    void successful(UserBean data);

    void failed(Exception e);
}
