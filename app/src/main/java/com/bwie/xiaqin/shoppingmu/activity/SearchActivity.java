package com.bwie.xiaqin.shoppingmu.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.adapterr.SearchAdapter;
import com.bwie.xiaqin.shoppingmu.bean.SearchBean;
import com.bwie.xiaqin.shoppingmu.mvp.SearchSou.presenter.SearchPresenter;
import com.bwie.xiaqin.shoppingmu.mvp.SearchSou.view.SearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 搜索跳转
 */

public class SearchActivity extends AppCompatActivity implements SearchView{
    private RecyclerView recyview;
    private List<SearchBean.ResultBean> mBeanList;

    private SearchAdapter mSearchAdapter;
    private SearchPresenter mSearchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shou_sou_search);

        recyview=findViewById(R.id.recy_view);
        Intent intent = getIntent();
        String keyword=intent.getStringExtra("keyword");
        Toast.makeText(this,""+keyword,Toast.LENGTH_SHORT).show();
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyview.setLayoutManager(manager);
        mBeanList=new ArrayList<>();
        mSearchAdapter=new SearchAdapter(this,mBeanList);
        recyview.setAdapter(mSearchAdapter);
        mSearchPresenter=new SearchPresenter();
        mSearchPresenter.attach(this);
        mSearchPresenter.getsearch(keyword,1,10);

        mSearchAdapter.setitemClickListener(new SearchAdapter.itemClickListener() {
            @Override
            public void itemClick(View itemView, int position) {
                int commodityId = mBeanList.get(position).getCommodityId();
                Intent intent = new Intent(SearchActivity.this,TranslActivity.class);
                intent.putExtra("commodityId",commodityId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getsearch(List<SearchBean.ResultBean> list) {
        if (list!=null){
            mBeanList.size();
            mBeanList.addAll(list);
            mSearchAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFailed(Exception e) {

    }
}
