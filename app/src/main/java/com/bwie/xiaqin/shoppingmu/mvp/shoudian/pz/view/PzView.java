package com.bwie.xiaqin.shoppingmu.mvp.shoudian.pz.view;

import com.bwie.xiaqin.shoppingmu.bean.PzBean;

import java.util.List;

/**
 * Created by lenovo on 2018/12/14.
 */

public interface PzView {
    void getRx(List<PzBean.ResultBean> list);

    void onfailed(Exception e);
}
