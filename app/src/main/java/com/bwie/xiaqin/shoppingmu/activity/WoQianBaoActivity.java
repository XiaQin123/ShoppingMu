package com.bwie.xiaqin.shoppingmu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.widget.ListView;
import android.widget.TextView;

import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.adapterr.WoQianBaoAdapter;
import com.bwie.xiaqin.shoppingmu.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class WoQianBaoActivity extends BaseActivity {

    private TextView my_waller_price;
    private ListView my_wallet_list_view;
    private List<String> list = new ArrayList<>();

    @Override
    protected void initView() {
        my_waller_price = findViewById(R.id.my_waller_price);
        my_wallet_list_view = findViewById(R.id.my_wallet_list_view);
        WoQianBaoAdapter adapter = new WoQianBaoAdapter(this, list);
        my_wallet_list_view.setAdapter(adapter);
    }


    @Override
    protected void initData() {
        //设置字体加粗
        TextPaint paint = my_waller_price.getPaint();
        paint.setFakeBoldText(true);
        for (int i = 0; i < 50; i++) {
            list.add("￥：1120.00");
        }

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int initLayout() {
        return R.layout.wo_qian_bao;
    }

    @Override
    protected boolean isFullScreen() {
        return false;
    }
}
