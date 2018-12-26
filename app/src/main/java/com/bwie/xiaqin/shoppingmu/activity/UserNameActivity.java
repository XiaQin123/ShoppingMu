package com.bwie.xiaqin.shoppingmu.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.Wo.username.presenter.UserNamePresenter;
import com.bwie.xiaqin.shoppingmu.Wo.username.view.UserNameView;
import com.bwie.xiaqin.shoppingmu.bean.RrgisterBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserNameActivity extends AppCompatActivity implements UserNameView{

    @BindView(R.id.new_name)
    EditText newName;
    @BindView(R.id.btn_name)
    Button btnName;
    private UserNamePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wo_user_name);
        ButterKnife.bind(this);
        presenter = new UserNamePresenter();
        presenter.attach(this);
    }
    @OnClick(R.id.btn_name)
    public void onViewClicked() {
        String name = newName.getText().toString();
        presenter.getUserName(name);
    }

    @Override
    public void success(RrgisterBean data) {
        if (data != null){
            Toast.makeText(this, "修改成功啦，不信你看看", Toast.LENGTH_SHORT).show();
            finish();
        }

    }

    @Override
    public void failed(Exception e) {
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
