package com.bwie.xiaqin.shoppingmu.app;

import android.app.Application;
import android.content.Context;

import com.bwie.xiaqin.shoppingmu.loginRegistration.net.net.LoginHttpNet;
import com.bwie.xiaqin.shoppingmu.utils.HttpNet;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by lenovo on 2018/12/8.
 */

public class App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        LoginHttpNet.init();
        context = this;
        HttpNet.init();


    }
}
