package com.bwie.xiaqin.shoppingmu.activity;

import android.os.Handler;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.adapterr.RxAdapters;
import com.bwie.xiaqin.shoppingmu.base.BaseActivity;
import com.bwie.xiaqin.shoppingmu.bean.RxBean;
import com.bwie.xiaqin.shoppingmu.mvp.shoudian.rx.presenter.RxPresenter;
import com.bwie.xiaqin.shoppingmu.mvp.shoudian.rx.view.RxView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/12/14.
 */

public class RxActivity extends BaseActivity implements RxView {
    private ImageView dian;
    private XRecyclerView rx_list;
    private RxPresenter presenter;
    private List<RxBean.ResultBean> rxList;
    private RxAdapters adapters;
    private int page = 0;
    @Override
    public void getRx(List<RxBean.ResultBean> list) {
        if (list!=null){
            rxList.clear();
            rxList.addAll(list);
            adapters.notifyDataSetChanged();
        }
    }

    @Override
    public void onfailed(Exception e) {
        Toast.makeText(this,"网络异常",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initView() {
        dian = findViewById(R.id.dian);
        rx_list = findViewById(R.id.rx_list);
        rxList = new ArrayList<>();


    }

    @Override
    protected void initData() {
        presenter = new RxPresenter();
        presenter.attach(this);
        presenter.getRx();

        adapters = new RxAdapters(this, rxList);
        rx_list.setAdapter(adapters);

//        RecyclerView.LayoutManager manager = new GridLayoutManager(RxActivity.this,2);
//        rx_list.setLayoutManager(manager);

        XRecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rx_list.setLayoutManager(layoutManager);
    }

    @Override
    protected void initListener() {
        dian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rx_list.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(RxActivity.this,"正在加载",Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rx_list.refreshComplete();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(RxActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
                        rx_list.loadMoreComplete();
                    }
                },2000);

            }
        });

    }

    @Override
    protected int initLayout() {
        return R.layout.shou_yuan_activity;
    }

    @Override
    protected boolean isFullScreen() {
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.onDestroy();
        }
    }
}
