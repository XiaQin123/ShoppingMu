package com.bwie.xiaqin.shoppingmu.Wo.user.model;

import android.os.Handler;

import com.bwie.xiaqin.shoppingmu.Car.Util;
import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.bwie.xiaqin.shoppingmu.utils.HttpNet;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by lenovo on 2018/12/17.
 */

public class UserModel {
    Handler handler = new Handler();
    public void getData(final ICallBack callback, final Type type){
        HttpNet.EnestenGet(Util.userUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailed(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                final Object o = gson.fromJson(result, type);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(o);
                    }
                });
            }
        });
    }
}
