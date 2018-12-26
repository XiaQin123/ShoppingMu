package com.bwie.xiaqin.shoppingmu.Car;

import com.bwie.xiaqin.shoppingmu.net.OKHeaderInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2018/12/16.
 */

public class RetrofitUtil {
    private static RetrofitUtil insetance;
    private final Retrofit retrofit;


    private RetrofitUtil() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(3000, TimeUnit.MILLISECONDS)
                .writeTimeout(3000, TimeUnit.MILLISECONDS)
                .addInterceptor(new OKHeaderInterceptor())
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Path.LABEL_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static RetrofitUtil getInsetance() {
        if (insetance == null) {
            synchronized (RetrofitUtil.class) {
                if (insetance == null) {
                    insetance = new RetrofitUtil();
                }
            }
        }
        return insetance;
    }

    public <T> T Create(Class<T> clazz) {
        return retrofit.create(clazz);
    }
}
