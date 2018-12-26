package com.bwie.xiaqin.shoppingmu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lenovo on 2018/12/8.
 */

public abstract class BaseActivity  extends AppCompatActivity{
    private boolean isFullScreen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        isFullScreen = isFullScreen();
        setContentView(initLayout());
        initView();
        initData();
        initListener();
    }
    //初始化控件
    protected abstract void initView();
    //处理逻辑
    protected abstract void initData();
    //负责监听
    protected abstract void initListener();
    //布局文件
    protected abstract int initLayout();

    protected abstract boolean isFullScreen();

}
