package com.bwie.xiaqin.shoppingmu.fragment;

import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.adapterr.QuanAdapter;
import com.bwie.xiaqin.shoppingmu.bean.QuanBean;
import com.bwie.xiaqin.shoppingmu.mvp.presenter.quan.QuanPresenter;
import com.bwie.xiaqin.shoppingmu.mvp.view.quan.QuanIView;

import java.util.ArrayList;
import java.util.List;

public class QuanFragment extends Fragment implements QuanIView{
    public static final String BUNDLE_TITLE = "title";

    private RecyclerView recy_view;
    private QuanPresenter presenter;
    private List<QuanBean.ResultBean> ListBean = new ArrayList<>();
    private QuanAdapter adapter;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quan_fragment, container, false);
        recy_view = view.findViewById(R.id.quan_recy);

        presenter = new QuanPresenter();
        presenter.attach(this);
        presenter.get();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recy_view.setLayoutManager(manager);

        //布局管理器
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recy_view.setLayoutManager(layoutManager);

        adapter = new QuanAdapter(getActivity(),ListBean);
        recy_view.setAdapter(adapter);



        return view;
    }
//成功
    @Override
    public void onSuccess(List<QuanBean.ResultBean> list) {
        if (list!=null){
            ListBean.clear();
            ListBean.addAll(list);
            adapter.notifyDataSetChanged();

        }

    }
//失败
    @Override
    public void onFailed(Exception e) {
        Toast.makeText(getActivity(),"网络连接错误",Toast.LENGTH_LONG).show();
    }
    public static QuanFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        QuanFragment fragment = new QuanFragment();
        fragment.setArguments(bundle);
        return fragment;

    }
//内存泄露
    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

}
