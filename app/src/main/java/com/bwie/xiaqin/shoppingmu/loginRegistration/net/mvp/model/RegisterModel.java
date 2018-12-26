package com.bwie.xiaqin.shoppingmu.loginRegistration.net.mvp.model;

import android.os.Handler;

import com.bwie.xiaqin.shoppingmu.bean.RrgisterBean;
import com.bwie.xiaqin.shoppingmu.loginRegistration.net.net.HttpCallBackRegister;
import com.bwie.xiaqin.shoppingmu.loginRegistration.net.net.LoginHttpNet;
import com.bwie.xiaqin.shoppingmu.loginRegistration.net.net.Util;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by lenovo on 2018/12/8.
 */

public class RegisterModel {
    private Handler handler = new Handler();

    public void register(String phone, String pwd, final HttpCallBackRegister callBackRegis) {
        HashMap<String, String> map = new HashMap();
        map.put("phone", phone);
        map.put("pwd", pwd);

        LoginHttpNet.EnestenPost(Util.REGISTER_URL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String data = response.body().string();
                Gson gson = new Gson();
                final RrgisterBean registerBean = gson.fromJson(data, RrgisterBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (registerBean.getStatus().equals("0000")) {
                            callBackRegis.onSuccess(registerBean.getMessage());
                        } else {
                            callBackRegis.onFaile(registerBean.getMessage());
                        }
                    }
                });
            }
        });
    }


}
