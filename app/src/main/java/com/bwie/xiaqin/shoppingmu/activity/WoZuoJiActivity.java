package com.bwie.xiaqin.shoppingmu.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.bwie.xiaqin.shoppingmu.R;

public class WoZuoJiActivity extends AppCompatActivity {
    private RecyclerView myFoot_recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wo_zuo_ji);
        initView();
        initData();

    }

    private void initData() {


    }

    private void initView() {
        //初始化控件
        myFoot_recycleView = findViewById(R.id.myFoot_recycleView);
    }
}
