package com.bwie.xiaqin.shoppingmu.loginRegistration.net;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.xiaqin.shoppingmu.MainActivity;
import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.base.BaseActivity;
import com.bwie.xiaqin.shoppingmu.bean.LoginBean;
import com.bwie.xiaqin.shoppingmu.loginRegistration.net.mvp.presenter.LoginPresenter;
import com.bwie.xiaqin.shoppingmu.loginRegistration.net.mvp.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView{
    private EditText mLoginPhone;
    private EditText mLoginPwd;
    private CheckBox mCheck;
    private TextView mRegisterJump;
    private Button mLoginBt;
    private LoginPresenter presenter;
    private SharedPreferences config;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initView();
        presenter = new LoginPresenter(this);
        initData();
        initSp();
    }

    private void initSp() {
        config = getSharedPreferences("config", MODE_PRIVATE);
        if (config.getString("phone", "") != null) {
            String phone = config.getString("phone", "");
            String pwd = config.getString("pwd", "");
            boolean box = config.getBoolean("box", false);
            mLoginPhone.setText(phone);
            mLoginPwd.setText(pwd);
            mCheck.setChecked(box);
        }
    }

    private void initData() {
        mLoginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = mLoginPhone.getText().toString().trim();
                String pwd = mLoginPwd.getText().toString().trim();
                presenter.login(phone, pwd);

                //判断是否记住密码
                if (mCheck.isChecked()) {
                    SharedPreferences.Editor edit = config.edit();
                    edit.putString("phone", phone);
                    edit.putString("pwd", pwd);
                    edit.putBoolean("box", true);
                    edit.commit();
                } else {
                    SharedPreferences.Editor edit = config.edit();
                    edit.clear();
                    edit.commit();
                }

            }
        });

        mRegisterJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mLoginPhone = findViewById(R.id.login_phone);
        mLoginPwd = findViewById(R.id.login_pwd);
        mCheck = findViewById(R.id.check);
        mRegisterJump = findViewById(R.id.register_jump);
        mLoginBt = findViewById(R.id.login_bt);
    }

    @Override
    public void OnSuccess(LoginBean result) {
        Toast.makeText(this, result.getMessage(), Toast.LENGTH_SHORT).show();

        //初始化sp
        SharedPreferences user = getSharedPreferences("user", MODE_PRIVATE);
        //添加数据
        SharedPreferences.Editor edit = user.edit();

        //存值
        edit.putString("headPic", result.getResult().getHeadPic())
                .putString("nickName", result.getResult().getNickName())
                .putString("sessionId", result.getResult().getSessionId())
                .putInt("userId", result.getResult().getUserId())
                .putBoolean("login", false)
                .commit();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();//关闭当前页
    }


    @Override
    public void OnFaile(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.onDestroy();
        }
    }
}
