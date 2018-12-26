package com.bwie.xiaqin.shoppingmu.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.base.BaseActivity;

public class WoShouHuoActivity extends BaseActivity {
    private TextView my_shipping_address_complete;



    @Override
    protected void initView() {
        my_shipping_address_complete = findViewById(R.id.my_shipping_address_complete);
    }

    @Override
    protected void initData() {
        my_shipping_address_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int initLayout() {
        return R.layout.wo_shou_huo;
    }

    @Override
    protected boolean isFullScreen() {
        return false;
    }
}
