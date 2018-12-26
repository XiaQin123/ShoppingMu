package com.bwie.xiaqin.shoppingmu.mvp.SearchSou.presenter;

import com.bwie.xiaqin.shoppingmu.bean.SearchBean;
import com.bwie.xiaqin.shoppingmu.mvp.SearchSou.model.SearchModel;
import com.bwie.xiaqin.shoppingmu.mvp.SearchSou.view.SearchView;
import com.bwie.xiaqin.shoppingmu.net.ICallBack;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/12/14.
 */

public class SearchPresenter {
    private SearchView mSearchView;
    private SearchModel mSearchModel;
    public void  attach(SearchView mSearchView){
        this.mSearchView=mSearchView;
        mSearchModel=new SearchModel();
    }
    public void getsearch(String keyword,int page,int count){
        Type type = new TypeToken<SearchBean>(){}.getType();
        mSearchModel.getSearch("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=" + keyword + "&page=" + page + "&count=" + count, new ICallBack() {
            @Override
            public void onSuccess(Object o) {
                SearchBean searchBean = (SearchBean) o;
                if (searchBean!=null){
                    mSearchView.getsearch(searchBean.getResult());
                }
            }

            @Override
            public void onFailed(Exception e) {
                mSearchView.onFailed(e);
            }
        },type);
    }

}
