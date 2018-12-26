package com.bwie.xiaqin.shoppingmu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.activity.DetailsActivity;
import com.bwie.xiaqin.shoppingmu.activity.MlActivity;
import com.bwie.xiaqin.shoppingmu.activity.PzActivity;
import com.bwie.xiaqin.shoppingmu.activity.RxActivity;
import com.bwie.xiaqin.shoppingmu.activity.SearchActivity;
import com.bwie.xiaqin.shoppingmu.adapterr.MlAdapter;
import com.bwie.xiaqin.shoppingmu.adapterr.PzAdapter;
import com.bwie.xiaqin.shoppingmu.adapterr.RxAdapter;
import com.bwie.xiaqin.shoppingmu.bean.Prouduct;
import com.bwie.xiaqin.shoppingmu.mvp.presenter.Presenter;
import com.bwie.xiaqin.shoppingmu.mvp.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bingoogolapple.bgabanner.BGABanner;

public class ShouFragment extends Fragment implements IView {
    public static final String BUNDLE_TITLE = "title";

    View view;
    Unbinder unbinder;
    @BindView(R.id.rx_image)
    ImageView mRxImage;
    @BindView(R.id.ml_image)
    ImageView mMlImage;
    @BindView(R.id.pz_image)
    ImageView mPzImage;
    private List<String> bannerList;
    private List<String> bannerUrl;
    private BGABanner banner;
    private Presenter presenter;
    private List<Prouduct.ResultBean.RxxpBean.CommodityListBean> rxList;
    private List<Prouduct.ResultBean.MlssBean.CommodityListBeanXX> mlList;
    private List<Prouduct.ResultBean.PzshBean.CommodityListBeanX> pzList;
    private PzAdapter pzAdapter;
    private MlAdapter mlAdapter;
    private RxAdapter rxAdapter;
    @BindView(R.id.recy_pz)
    RecyclerView recy_pz;
    @BindView(R.id.recy_ml)
    RecyclerView recy_ml;
    @BindView(R.id.recy_rx)
    RecyclerView recy_rx;
    @BindView(R.id.sousuo)
    ImageView sousuo;

    //轮播图
    private String[] BannerUrl = {
            "http://172.17.8.100/images/small/banner/cj.png",
            "http://172.17.8.100/images/small/banner/hzp.png",
            "http://172.17.8.100/images/small/banner/lyq.png",
            "http://172.17.8.100/images/small/banner/px.png",
            "http://172.17.8.100/images/small/banner/wy.png"

    };
    private String[] BannerText = {
            "抽奖", "美妆工具", "连衣裙", "跑鞋", "卫衣"
    };
    private EditText mEtxtSearch;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.shou_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        banner = view.findViewById(R.id.bannner);
        mEtxtSearch = view.findViewById(R.id.txt_search);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setBanner();
        setData();
        setPz();
        setMl();
        setRx();
    }

    private void setData() {
        presenter = new Presenter();
        presenter.attach(this);
        presenter.getMxData();
        presenter.getPzData();
        presenter.getRxData();

        rxList = new ArrayList<>();
        mlList = new ArrayList<>();
        pzList = new ArrayList<>();

    }

    private void setBanner() {
        bannerList = new ArrayList<>();
        bannerUrl = new ArrayList<>();
        for (int i = 0; i < BannerUrl.length; i++) {
            bannerList.add(BannerUrl[i]);
            bannerUrl.add(BannerText[i]);
        }
        banner.setData(bannerList, bannerUrl);
        banner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, @Nullable String model, int position) {
                Glide.with(getActivity()).load(bannerList.get(position)).into(itemView);
            }
        });
    }

    @Override
    public void getRxData(List<Prouduct.ResultBean.RxxpBean.CommodityListBean> list) {
        rxAdapter.setOnRxListLinener(new RxAdapter.onRxClickListener() {
            @Override
            public void onRxClick(View view, int position) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                startActivity(intent);
            }
        });

        if (list != null) {
            rxList.clear();
            rxList.addAll(list);
        }
    }

    @Override
    public void getMxData(List<Prouduct.ResultBean.MlssBean.CommodityListBeanXX> list) {
        if (list != null) {
            mlList.clear();
            mlList.addAll(list);
        }
    }

    @Override
    public void getPzData(List<Prouduct.ResultBean.PzshBean.CommodityListBeanX> list) {
        if (list != null) {
            pzList.clear();
            pzList.addAll(list);
        }
    }

    //品质生活
    private void setPz() {
        pzAdapter = new PzAdapter(getActivity(), pzList);
        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recy_pz.setLayoutManager(manager);
        recy_pz.setAdapter(pzAdapter);
    }

    //魔力时尚
    private void setMl() {
        mlAdapter = new MlAdapter(getActivity(), mlList);
        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
        recy_ml.setLayoutManager(manager);
        recy_ml.setAdapter(mlAdapter);
    }

    //热销新品
    private void setRx() {
        rxAdapter = new RxAdapter(getActivity(), rxList);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity(), 3);
        recy_rx.setLayoutManager(manager);
        recy_rx.setAdapter(rxAdapter);
    }

    @Override
    public void onFailed(Exception e) {
        Toast.makeText(getActivity(), "网络异常", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.rx_image, R.id.ml_image, R.id.pz_image,R.id.sousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //加载更多
            case R.id.rx_image:
                Intent intent = new Intent(getActivity(), RxActivity.class);
                startActivity(intent);
                break;
            case R.id.ml_image:
                Intent intent2 = new Intent(getActivity(), MlActivity.class);
                startActivity(intent2);
                break;
            case R.id.pz_image:
                Intent intent1 = new Intent(getActivity(), PzActivity.class);
                startActivity(intent1);
                break;
                //搜索跳转
            case R.id.sousuo:
                String string = mEtxtSearch.getText().toString();
                Intent intent3 = new Intent(getContext(), SearchActivity.class);
                intent3.putExtra("keyword", string);
                startActivity(intent3);
                break;
        }
    }
    //内存泄露
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detach();
        }
        unbinder.unbind();
    }
    public static ShouFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        ShouFragment fragment = new ShouFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


  /*
//  这是一个有问题的
   @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
    */

}