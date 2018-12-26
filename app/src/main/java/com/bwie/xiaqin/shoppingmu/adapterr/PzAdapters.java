package com.bwie.xiaqin.shoppingmu.adapterr;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.bean.PzBean;

import java.util.List;

/**
 * Created by lenovo on 2018/12/14.
 */

public class PzAdapters extends RecyclerView.Adapter<PzAdapters.ViewHolder> {
    private Context context;
    private List<PzBean.ResultBean> list;

    public PzAdapters(Context context, List<PzBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.shou_yuan_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getMasterPic()).into(holder.imageView);
        holder.textView.setText(list.get(position).getCommodityName());
        holder.text_price.setText("￥：" + list.get(position).getPrice());
        holder.text_num.setText("已售"+list.get(position).getSaleNum()+"件");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        TextView text_price;
        TextView text_num;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_rx2);
            textView = itemView.findViewById(R.id.text_rx2);
            text_price = itemView.findViewById(R.id.text_rx_price2);
            text_num = itemView.findViewById(R.id.text_rx_num);
        }
    }
}
