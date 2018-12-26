package com.bwie.xiaqin.shoppingmu.mvp.view.quan;

import com.bwie.xiaqin.shoppingmu.bean.QuanBean;

import java.util.List;

/**
 * Created by lenovo on 2018/12/12.
 */

public interface QuanIView {
    void onSuccess(List<QuanBean.ResultBean> list);
    void onFailed(Exception e);

}
