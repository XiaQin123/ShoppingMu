package com.bwie.xiaqin.shoppingmu.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.xiaqin.shoppingmu.activity.GeRenDataActivity;
import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.activity.MyActivity;
import com.bwie.xiaqin.shoppingmu.activity.WoQianBaoActivity;
import com.bwie.xiaqin.shoppingmu.activity.WoQuanziActivity;
import com.bwie.xiaqin.shoppingmu.activity.WoShouHuoActivity;
import com.bwie.xiaqin.shoppingmu.activity.WoZuoJiActivity;
import com.bwie.xiaqin.shoppingmu.loginRegistration.net.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class WoFragment extends Fragment{
    public static final String BUNDLE_TITLE = "title";
    @BindView(R.id.my_name)
    TextView myName;
    @BindView(R.id.personal_data)
    TextView myData;
    @BindView(R.id.my_circle)
    TextView myCircle;
    @BindView(R.id.my_footprint)
    TextView myFootprint;
    @BindView(R.id.my_wallet)
    TextView myWallet;
    @BindView(R.id.my_address)
    TextView myAddress;
    @BindView(R.id.portrait)
    ImageView portrait;
    private SharedPreferences sp;
    private View view;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.wo_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        sp = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        boolean isFirst = sp.getBoolean("login", true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @OnClick({R.id.my_name, R.id.personal_data, R.id.my_circle, R.id.my_footprint, R.id.my_wallet, R.id.my_address, R.id.portrait})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_name:
                if (!sp.getBoolean("login", true)) {
                    Intent intent2 = new Intent(getActivity(), MyActivity.class);
                    startActivity(intent2);
                } else {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.personal_data:
                if (!sp.getBoolean("login", true)) {
                    Intent intent3 = new Intent(getActivity(), GeRenDataActivity.class);
                    startActivity(intent3);
                } else {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.my_circle:
                if (!sp.getBoolean("login", true)) {
                    Intent intent3 = new Intent(getActivity(), WoQuanziActivity.class);
                    startActivity(intent3);
                } else {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.my_footprint:
                if (!sp.getBoolean("login", true)) {
                    Intent intent3 = new Intent(getActivity(), WoZuoJiActivity.class);
                    startActivity(intent3);
                } else {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.my_wallet:
                if (!sp.getBoolean("login", true)) {
                    Intent intent3 = new Intent(getActivity(), WoQianBaoActivity.class);
                    startActivity(intent3);
                } else {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.my_address:
                if (!sp.getBoolean("login", true)) {
                    Intent intent3 = new Intent(getActivity(), WoShouHuoActivity.class);
                    startActivity(intent3);
                } else {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.portrait:
                if (!sp.getBoolean("login", true)) {
                    Intent intent2 = new Intent(getActivity(), MyActivity.class);
                    startActivity(intent2);
                } else {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!sp.getBoolean("login",true)){
            String timg = sp.getString("headPic", "");
            String name = sp.getString("nickName", "");
            myName.setText(name);
            Glide.with(getActivity()).load(timg).into(portrait);
        }else{
            portrait.setImageResource(R.drawable.bitmap);
            myName.setText("请先登录/注册");
        }
    }
    public static WoFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        WoFragment fragment = new WoFragment();
        fragment.setArguments(bundle);
        return fragment;

    }

}
