package com.bwie.xiaqin.shoppingmu.mvp.SearchSou.view;

import com.bwie.xiaqin.shoppingmu.bean.SearchBean;

import java.util.List;

/**
 * Created by lenovo on 2018/12/14.
 */

public interface SearchView {
    void  getsearch(List<SearchBean.ResultBean> list);
    void  onFailed(Exception e);

}
