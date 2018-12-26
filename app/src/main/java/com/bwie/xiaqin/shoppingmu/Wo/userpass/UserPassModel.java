package com.bwie.xiaqin.shoppingmu.Wo.userpass;

import android.os.Handler;

import com.bwie.xiaqin.shoppingmu.Car.Util;
import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.bwie.xiaqin.shoppingmu.utils.HttpNet;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by lenovo on 2018/12/17.
 */

public class UserPassModel {
    Handler handler = new Handler();
    public void getData(String yPaw, String xPaw, final ICallBack callBack, final Type type){
        HashMap map = new HashMap();
        map.put("oldPwd",yPaw);
        map.put("newPwd",xPaw);
        HttpNet.EnestenPut(Util.userPawUrl, map, new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onFailed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson=new Gson();
                final Object o = gson.fromJson(result,type);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(o);
                    }
                });
            }
        },type);
    }
}
