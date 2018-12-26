package com.bwie.xiaqin.shoppingmu.net;

import android.content.Context;
import android.content.SharedPreferences;

import com.bwie.xiaqin.shoppingmu.app.App;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2018/12/16.
 * 购物车请求头
 */

public class OKHeaderInterceptor implements Interceptor{
    @Override
    public Response intercept(Chain chain) throws IOException {
        SharedPreferences user = App.context.getSharedPreferences("user", Context.MODE_PRIVATE);
        String sessionId = user.getString("sessionId", "");
        int userId = user.getInt("userId", 0);
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        builder.addHeader("sessionId",sessionId);
        builder.addHeader("userId",userId+"");


        request = builder.build();
        return chain.proceed(request);
    }
}
