package com.bwie.xiaqin.shoppingmu.mvp.shoudian.rx.view;

import com.bwie.xiaqin.shoppingmu.bean.RxBean;

import java.util.List;

/**
 * Created by lenovo on 2018/12/14.
 */

public interface RxView {
    void getRx(List<RxBean.ResultBean> list);

    void onfailed(Exception e);
}
