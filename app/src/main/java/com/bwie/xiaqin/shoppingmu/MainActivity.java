package com.bwie.xiaqin.shoppingmu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import com.bwie.xiaqin.shoppingmu.fragment.CarFragment;
import com.bwie.xiaqin.shoppingmu.fragment.DingFragment;
import com.bwie.xiaqin.shoppingmu.fragment.QuanFragment;
import com.bwie.xiaqin.shoppingmu.fragment.ShouFragment;
import com.bwie.xiaqin.shoppingmu.fragment.WoFragment;
import com.hjm.bottomtabbar.BottomTabBar;
import com.yinglan.alphatabs.AlphaTabsIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

//主体的F布局,使用的是ViewPager

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.mViewPager)
    ViewPager mViewPger;
//     @BindView(R.id.bottom_tab_bar)
//    BottomTabBar bottomTabBar;
    Unbinder unbinder;
    @BindView(R.id.alphaIndicator)
    AlphaTabsIndicator alphaTabsIndicator;

    private final int ITEM_ONE = 0;
    private final int ITEM_TWO = 2;
    private final int ITEM_THRE = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //全屏沉浸式
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定,在后面的这个都是一个绑定,没有做全局变量,,做成全局变量后有时会出现找不到xml的id值
        unbinder = ButterKnife.bind(this);
        //initDataDiBu();
        //自定义内部适配器
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager());
        mViewPger.setAdapter(mainAdapter);
        mViewPger.addOnPageChangeListener(mainAdapter);

        alphaTabsIndicator.setViewPager(mViewPger);

        //这是我的Number数量,也就是我们经常看到的消息的数量,看自己的定义,我这里是将他注释掉了,等项目完成后进行展示
//        alphaTabsIndicator.getTabView(0).showNumber(6);
//        alphaTabsIndicator.getTabView(1).showNumber(888);
//        alphaTabsIndicator.getTabView(2).showNumber(88);
//        alphaTabsIndicator.getTabView(3).showPoint();
        // 最后一个是重新绘画,也就是没有消息,在哪个页面都可以使用
        alphaTabsIndicator.getTabView(0);
        alphaTabsIndicator.getTabView(1);
        alphaTabsIndicator.getTabView(2);
        alphaTabsIndicator.getTabView(3);
    }
    //底部导航
    class MainAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener{
        List<Fragment> fragments = new ArrayList<>();
        String[] titles={"首页","圈子","购物车","订单","我的"};
        public MainAdapter(FragmentManager fm) {
            super(fm);
            fragments.add(ShouFragment.newInstance(titles[0]));
            fragments.add(QuanFragment.newInstance(titles[1]));
            fragments.add(CarFragment.newInstance(titles[2]));
            fragments.add(DingFragment.newInstance(titles[3]));
            fragments.add(WoFragment.newInstance(titles[4]));
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            这里是在页面滑动的时候进行的一个动画的效果,根据自己的喜好去设计


        }

        @Override
        public void onPageSelected(int position) {
//            当滑动时我们几个F进行的交换
            if (ITEM_ONE == position) {
                alphaTabsIndicator.getTabView(0).showNumber(alphaTabsIndicator.getTabView(0).getBadgeNumber() - 1);
            } else if (ITEM_TWO == position) {
                alphaTabsIndicator.getCurrentItemView().removeShow();
            } else if (ITEM_THRE == position) {
                alphaTabsIndicator.removeAllBadge();
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {
            //改变时发生的状态,还在等我去进行一个整体的效果

        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if (requestCode == Activity.RESULT_FIRST_USER) {
            if (requestCode == RESULT_CANCELED) {

            }
        }
    }
    //底部导航
//    private void initDataDiBu() {
//        bottomTabBar.init(getSupportFragmentManager())
//                .setFontSize(10)
//                .setChangeColor(Color.RED, Color.DKGRAY)
//                .addTabItem("首页", R.mipmap.common_tab_btn_home_n_hdpi, ShouFragment.class)
//                .addTabItem("圈子", R.mipmap.common_tab_btn_circle_n_hdpi, QuanFragment.class)
//                .addTabItem("购物车", R.mipmap.commom_tab_btn_shopping_cart_n_hdpi, CarFragment.class)
//                .addTabItem("订单", R.mipmap.common_tab_btn_list_n_hdpi, DingFragment.class)
//                .addTabItem("我的", R.mipmap.common_tab_btn_my_n_hdpi, WoFragment.class)
//                .setTabBarBackgroundColor(Color.WHITE)
//                .isShowDivider(false);
//
//    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        unbinder.unbind();
    }
}