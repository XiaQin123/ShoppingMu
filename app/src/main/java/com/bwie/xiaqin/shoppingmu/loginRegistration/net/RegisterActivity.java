package com.bwie.xiaqin.shoppingmu.loginRegistration.net;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.request.Request;
import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.loginRegistration.net.mvp.presenter.RegisterPresenter;
import com.bwie.xiaqin.shoppingmu.loginRegistration.net.mvp.view.RegisterView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements RegisterView{
    @BindView(R.id.te_jump)
    TextView mTeJump;
    @BindView(R.id.register_phone)
    EditText mRegisterPhone;
    @BindView(R.id.register_code)
    EditText mRegisterCode;
    @BindView(R.id.register_pwd)
    EditText mRegisterPwd;
    @BindView(R.id.bt_register)
    Button mBtRegister;
    private RegisterPresenter registerPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        ButterKnife.bind(this);
        registerPresenter = new RegisterPresenter(this);
    }
    @OnClick({R.id.te_jump, R.id.register_phone, R.id.register_code, R.id.register_pwd, R.id.bt_register})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.te_jump:
                //已有账号
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.bt_register:
                //注册
                String phone = mRegisterPhone.getText().toString().trim();
                String pwd = mRegisterPwd.getText().toString().trim();
                registerPresenter.register(phone, pwd);
                break;
        }
    }

        @Override
    public void onSuccess(String data) {
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        }

    @Override
    public void onFaile(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
}
