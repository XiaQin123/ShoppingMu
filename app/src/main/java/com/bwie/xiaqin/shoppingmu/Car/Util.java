package com.bwie.xiaqin.shoppingmu.Car;

import com.bwie.xiaqin.shoppingmu.bean.CarBean;
import com.bwie.xiaqin.shoppingmu.bean.QuanBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2018/12/16.
 */

public interface Util {
    String LOGIN_URL = "http://172.17.8.100/small/user/v1/login";

    String REGISTER_URL = "http://172.17.8.100/small/user/v1/register";

    //用户
    String userUrl="http://172.17.8.100/small/user/verify/v1/getUserById";
    //用户名字
    String userNameUrl="http://172.17.8.100/small/user/verify/v1/modifyUserNick";
    //用户密码
    String userPawUrl="http://172.17.8.100/small/user/verify/v1/modifyUserPwd";
    //圈子
    @GET("circle/v1/findCircleList")
    Observable<QuanBean> getcircle(@Query("page") int page, @Query("count") int count);
    //购物车
    @GET("order/verify/v1/findShoppingCart")
    Observable<CarBean> getShopCar();
}
