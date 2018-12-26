package com.bwie.xiaqin.shoppingmu.utils;

import com.bwie.xiaqin.shoppingmu.loginRegistration.net.net.RequestGet;
import com.bwie.xiaqin.shoppingmu.net.OKHeaderInterceptor;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by lenovo on 2018/12/16.
 * 封装
 */

public class HttpNet {
    private HttpNet() {
    }
    private static final String MEDIA_TYPE="application/json; charset=utf_8";
    private static final String MODEL_GET = "GET";
    private static final String MODEL_POST = "POST";
    private static final String MODEL_PUP = "PUT";
    private static final String MODELD_DELETE = "DELETE";
    private static final Gson gson = new Gson();
    private static OkHttpClient okHttpClient;

    public static void init() {
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(3000, TimeUnit.MILLISECONDS);
        builder.addInterceptor(new OKHeaderInterceptor());//添加请求头
//        builder.addInterceptor(new OkLogInterceptor());//打印log
        okHttpClient = builder.build();
    }

    //json
    private static Request CreateRequest(String url, String method, RequestGet requestGet) {
        RequestBody requestBody = null;
        if (requestGet != null) {
            String toJson = gson.toJson(requestGet);
            MediaType parse = MediaType.parse("application/json; charset=utf-8");
            requestBody = RequestBody.create(parse, toJson);
        }
        Request.Builder builder = new Request.Builder().url(url);
        Request request = null;
        switch (method) {
            case MODEL_GET:
                request = builder.get().build();
                break;
            case MODEL_POST:
                request = builder.post(requestBody).build();
                break;
            case MODEL_PUP:
                if (requestBody != null) {
                    request = builder.put(requestBody).build();
                }
                break;
            case MODELD_DELETE:
                if (requestBody != null) {
                    request = builder.delete(requestBody).build();
                } else {
                    request = builder.delete().build();
                }
                break;
        }
        return request;
    }
    public static Request createRequestPost(String url, String method, Map<String,String> map){
        FormBody.Builder form=new FormBody.Builder();
        Set set=map.keySet();
        Iterator iterator = set.iterator();
        String logString="";
        while (iterator.hasNext()){
            String next= (String) iterator.next();
            form.add(next,map.get(next));
            logString+=next+":"+map.get(next)+"/n";
        }

//        LoggerUtil.d("==="+logString);

        FormBody formBody = form.build();
        Request.Builder builder=new Request.Builder().url(url);
        Request request=null;
        switch (method){
            case MODEL_GET:
                request=builder.get().build();
                break;
            case MODEL_POST:
                request=builder.post(formBody).build();
                break;
            case MODEL_PUP:
                if (formBody!=null){
                    request=builder.put(formBody).build();
                }
                break;
            case MODELD_DELETE:
                if (formBody!=null){
                    request=builder.delete(formBody).build();
                }else {
                    request=builder.delete().build();
                }
                break;
        }
        return request;
    }

    //Map键值对
    private static Request CreateRequest(String url, String method, Map<String, String> requestGet) {
        FormBody.Builder form = new FormBody.Builder();
        Set set = requestGet.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = (String) iterator.next();
            form.add(next, requestGet.get(next));
        }
        FormBody formBody = form.build();
        Request.Builder builder = new Request.Builder().url(url);
        Request request = null;
        switch (method) {
            case MODEL_GET:
                request = builder.get().build();
                break;
            case MODEL_POST:
                request = builder.post(formBody).build();
                break;
            case MODEL_PUP:
                if (formBody != null) {
                    request = builder.put(formBody).build();
                }
                break;
            case MODELD_DELETE:
                if (formBody != null) {
                    request = builder.delete(formBody).build();
                } else {
                    request = builder.delete().build();
                }
                break;
        }
        return request;
    }

    //    post异步请求
    public static void EnestenPost(String url, RequestGet requestGet, Callback callback) {
        Request request = CreateRequest(url, MODEL_POST, requestGet);
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    //post请求map键值对
    public static void EnestenPost(String url, Map requestGet, Callback callback) {
        Request request = CreateRequest(url, MODEL_POST, requestGet);
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    //get异步请求
    public static void EnestenGet(String url, Callback callback) {
        Request request = CreateRequest(url, MODEL_GET, (RequestGet) null);
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);

    }
    //异步put方法
    public static void EnestenPut(String url,Map map,Callback callback,Type type){
        Request request=createRequestPost(url,MODEL_PUP,map);
        Call call=okHttpClient.newCall(request);
        call.enqueue(callback);
    }

}
