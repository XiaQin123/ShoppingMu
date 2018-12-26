package com.bwie.xiaqin.shoppingmu.mvp.shoudian.ml.view;

import com.bwie.xiaqin.shoppingmu.bean.MlBean;

import java.util.List;

/**
 * Created by lenovo on 2018/12/14.
 */

public interface MlView {
    void getMl(List<MlBean.ResultBean> list);

    void onfailed(Exception e);
}
