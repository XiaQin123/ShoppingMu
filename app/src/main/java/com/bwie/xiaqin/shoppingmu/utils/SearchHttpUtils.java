package com.bwie.xiaqin.shoppingmu.utils;

import android.os.Handler;

import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2018/12/15.
 */

public class SearchHttpUtils {
    private static volatile SearchHttpUtils instance;
    private OkHttpClient client;
    private Handler handler=new Handler();

    private SearchHttpUtils(){
        client=new OkHttpClient();
    }

    public static SearchHttpUtils getInstance(){
        if (instance==null){
            synchronized (SearchHttpUtils.class){
                if (null==instance){
                    instance=new SearchHttpUtils();
                }
            }
        }
        return  instance;
    }

    public void get(String url, final ICallBack callBack, final Type type) {
        final Request request = new Request.Builder().url(url).get().build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onFailed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                final Object o = gson.fromJson(string, type);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(o);
                    }
                });
            }
        });
    }
}
