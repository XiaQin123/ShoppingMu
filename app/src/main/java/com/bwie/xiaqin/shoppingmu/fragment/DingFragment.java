package com.bwie.xiaqin.shoppingmu.fragment;

import android.support.v4.app.Fragment;;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.xiaqin.shoppingmu.R;

public class DingFragment extends Fragment {
    public static final String BUNDLE_TITLE = "title";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ding_fragment, container, false);
        return view;
    }


    public static DingFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        DingFragment fragment = new DingFragment();
        fragment.setArguments(bundle);
        return fragment;

    }
}
