package com.bwie.xiaqin.shoppingmu.activity;

import android.os.Handler;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.adapterr.PzAdapters;
import com.bwie.xiaqin.shoppingmu.base.BaseActivity;
import com.bwie.xiaqin.shoppingmu.bean.PzBean;
import com.bwie.xiaqin.shoppingmu.mvp.shoudian.pz.presenter.PzPresenter;
import com.bwie.xiaqin.shoppingmu.mvp.shoudian.pz.view.PzView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/12/14.
 */

public class PzActivity extends BaseActivity implements PzView{
    private ImageView dian;
    private XRecyclerView rx_list;
    private PzPresenter presenter;
    private List<PzBean.ResultBean> rxList;
    private PzAdapters adapters;
    @Override
    public void getRx(List<PzBean.ResultBean> list) {
        if (list != null){
            rxList.clear();
            rxList.addAll(list);
            adapters.notifyDataSetChanged();
        }
    }

    @Override
    public void onfailed(Exception e) {
        Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initView() {
        dian = findViewById(R.id.dian);
        rx_list = findViewById(R.id.rx_list);
        rxList = new ArrayList<>();
    }

    @Override
    protected void initData() {
        presenter = new PzPresenter();
        presenter.attach(this);
        presenter.getPz();

        adapters = new PzAdapters(this,rxList);
        rx_list.setAdapter(adapters);

//        RecyclerView.LayoutManager manager = new GridLayoutManager(RxActivity.this,2);
//        rx_list.setLayoutManager(manager);

        XRecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rx_list.setLayoutManager(layoutManager);

    }

    @Override
    protected void initListener() {
        dian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        rx_list.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(PzActivity.this, "正在加载", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(PzActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
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
        if (presenter != null){
            presenter.onDestroy();
        }
    }
}
