package com.bwie.xiaqin.shoppingmu.mvp.car.presenter;

import com.bwie.xiaqin.shoppingmu.bean.CarBean;
import com.bwie.xiaqin.shoppingmu.mvp.car.model.CarModel;
import com.bwie.xiaqin.shoppingmu.mvp.car.view.CarView;
import com.bwie.xiaqin.shoppingmu.net.CarCallBack;


/**
 * Created by lenovo on 2018/12/16.
 */

public class CarPresenter {
    private CarView sv;
    private CarModel model;

    public void attach(CarView sv) {
        this.sv = sv;
        model = new CarModel();
    }

    public void ShopCar() {
            model.car(new CarCallBack() {
            @Override
            public void shopcarSuccess(Object data) {
                CarBean shopCarBean = (CarBean) data;
                if (shopCarBean != null) {
                    sv.onShopCar(shopCarBean);
                }
            }

            @Override
            public void shopcarFaile(Exception data) {
                sv.onShopCarFaile(data);
            }
        });
    }

    public void onDestroy() {
        if (sv != null) {
            sv = null;
        }
    }
}
