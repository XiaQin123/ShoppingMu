package com.bwie.xiaqin.shoppingmu.loginRegistration.net.mvp.model;

import android.os.Handler;
import android.os.Message;

import com.bwie.xiaqin.shoppingmu.bean.LoginBean;
import com.bwie.xiaqin.shoppingmu.loginRegistration.net.net.HttpCallback;
import com.bwie.xiaqin.shoppingmu.loginRegistration.net.net.LoginHttpNet;

import com.bwie.xiaqin.shoppingmu.loginRegistration.net.net.Util;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by lenovo on 2018/12/8.
 */

public class LoginModel {

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };

    public void login(String phone, String pwd, final HttpCallback httpCallback) {
        Map<String, String> map = new HashMap();
        map.put("phone", phone);
        map.put("pwd", pwd);

        LoginHttpNet.EnestenPost(Util.LOGIN_URL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                final LoginBean login_bean = gson.fromJson(string, LoginBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (login_bean.getStatus().equals("0000")) {
                            httpCallback.OnSuccess(login_bean);
                        } else {
                            httpCallback.OnFaile(login_bean.getMessage());
                        }

                    }
                });
            }
        });
    }
}
