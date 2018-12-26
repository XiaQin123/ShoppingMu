package com.bwie.xiaqin.shoppingmu.mvp.car.view;

import com.bwie.xiaqin.shoppingmu.bean.CarBean;

/**
 * Created by lenovo on 2018/12/16.
 */

public interface CarView {
    void onShopCar(CarBean data);

    void onShopCarFaile(Exception msg);
}
