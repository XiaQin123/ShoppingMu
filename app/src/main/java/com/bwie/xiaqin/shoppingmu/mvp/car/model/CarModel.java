package com.bwie.xiaqin.shoppingmu.mvp.car.model;

import android.annotation.SuppressLint;

import com.bwie.xiaqin.shoppingmu.Car.RetrofitUtil;
import com.bwie.xiaqin.shoppingmu.Car.Util;
import com.bwie.xiaqin.shoppingmu.bean.CarBean;
import com.bwie.xiaqin.shoppingmu.net.CarCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/12/16.
 */

public class CarModel {
    @SuppressLint("CheckResult")
    public void car(final CarCallBack carCallBack) {
        Util create = RetrofitUtil.getInsetance().Create(Util.class);

        create.getShopCar()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CarBean>() {
                    @Override
                    public void accept(CarBean carBean) throws Exception {
                        if (carBean != null) {
                            carCallBack.shopcarSuccess(carBean);
                        } else {
                            carCallBack.shopcarFaile(new Exception(carBean.getMessage()));
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        carCallBack.shopcarFaile((Exception) throwable);
                    }
                });
    }
}
