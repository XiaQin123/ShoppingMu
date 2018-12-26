package com.bwie.xiaqin.shoppingmu.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.Wo.user.presenter.UserPresenter;
import com.bwie.xiaqin.shoppingmu.Wo.user.view.UserView;
import com.bwie.xiaqin.shoppingmu.bean.UserBean;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GeRenDataActivity extends AppCompatActivity implements UserView {
    @BindView(R.id.my_tou)
    SimpleDraweeView myTou;
    @BindView(R.id.my_name)
    TextView myName;
    @BindView(R.id.my_pwd)
    TextView myPwd;
    private UserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wo_ge_ren_data);
        ButterKnife.bind(this);
        presenter = new UserPresenter();
        presenter.attach(this);
        presenter.getUser();
    }

    @Override
    public void successful(UserBean data) {
        if (data != null){
            UserBean.ResultBean list = data.getResult();
            myTou.setImageURI(list.getHeadPic());
            myName.setText(list.getNickName());
            myPwd.setText(list.getPassword());
        }
    }

    @Override
    public void failed(Exception e) {
        Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();

    }
    @OnClick({R.id.my_name, R.id.my_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_name:
                Intent intent = new Intent(this,UserNameActivity.class);
                startActivity(intent);
                break;
            case R.id.my_pwd:
                Intent intent1 = new Intent(this,UserPassActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getUser();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.onDestroy();
        }
    }
}
