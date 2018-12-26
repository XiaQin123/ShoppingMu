package com.bwie.xiaqin.shoppingmu.mvp.view;

import com.bwie.xiaqin.shoppingmu.bean.Prouduct;

import java.util.List;

/**
 * Created by lenovo on 2018/12/6.
 */

public interface IView {

    void getRxData(List<Prouduct.ResultBean.RxxpBean.CommodityListBean> list);

    void getMxData(List<Prouduct.ResultBean.MlssBean.CommodityListBeanXX> list);

    void getPzData(List<Prouduct.ResultBean.PzshBean.CommodityListBeanX> list);

    void onFailed(Exception e);

}
