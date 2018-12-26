package com.bwie.xiaqin.shoppingmu.adapterr;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.bean.SearchBean;

import java.util.List;

/**
 * Created by lenovo on 2018/12/14.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{
    private Context mContext;
    private List<SearchBean.ResultBean> mList;

    public SearchAdapter(Context context, List<SearchBean.ResultBean> list) {
        mContext = context;
        mList = list;
    }
    //接口回调
    public interface itemClickListener{
        void itemClick(View itemView, int position);
    }

    public itemClickListener mListener;

    public  void setitemClickListener(itemClickListener listener){
        this.mListener = listener;
    }

    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(mContext, R.layout.shou_sou_item, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(SearchAdapter.ViewHolder holder,final int position) {
        Glide.with(mContext).load(mList.get(position).getMasterPic()).into(holder.img);
        holder.title.setText(mList.get(position).getCommodityName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener!=null){
                    mListener.itemClick(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            title=itemView.findViewById(R.id.title);
        }
    }
}
