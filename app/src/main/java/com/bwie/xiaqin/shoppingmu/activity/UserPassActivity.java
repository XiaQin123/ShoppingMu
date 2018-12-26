package com.bwie.xiaqin.shoppingmu.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.Wo.userpass.UserPassPresenter;
import com.bwie.xiaqin.shoppingmu.Wo.userpass.UserPassView;
import com.bwie.xiaqin.shoppingmu.bean.RrgisterBean;
import com.bwie.xiaqin.shoppingmu.loginRegistration.net.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserPassActivity extends AppCompatActivity implements UserPassView{
    @BindView(R.id.paw)
    EditText paw;
    @BindView(R.id.new_paw)
    EditText newPaw;
    @BindView(R.id.btn_name)
    Button btnName;
    private UserPassPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wo__user_pass);
        ButterKnife.bind(this);
        presenter = new UserPassPresenter();
        presenter.attach(this);
    }
    @OnClick(R.id.btn_name)
    public void onViewClicked() {
        String yPas = paw.getText().toString().trim();
        String xPas = newPaw.getText().toString().trim();
        presenter.getUserPwd(yPas,xPas);
    }

    @Override
    public void success(RrgisterBean data) {
        if (data != null){
            Toast.makeText(this, "密码"+data.getMessage()+"请重新登录", Toast.LENGTH_SHORT).show();
            SharedPreferences user = getSharedPreferences("user", MODE_PRIVATE);
            finish();
            user.edit().clear().commit();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onfailed(Exception e) {
        Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.onDestroy();
        }
    }
}
