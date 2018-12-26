package com.bwie.xiaqin.shoppingmu.adapterr;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.xiaqin.shoppingmu.activity.DetailsActivity;
import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.bean.Prouduct;

import java.util.List;

/**
 * Created by lenovo on 2018/12/7.
 */

public class PzAdapter extends RecyclerView.Adapter<PzAdapter.ViewHolder> {
    private Context context;
    private List<Prouduct.ResultBean.PzshBean.CommodityListBeanX> list;

    public PzAdapter(Context context, List<Prouduct.ResultBean.PzshBean.CommodityListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public PzAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.shou_pz_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PzAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getMasterPic()).into(holder.imageView);
        holder.textView.setText(list.get(position).getCommodityName());
        holder.text_price.setText("¥:"+list.get(position).getPrice());

        //品质点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailsActivity.class);

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private TextView text_price;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_pz);
            textView = itemView.findViewById(R.id.text_pz);
            text_price = itemView.findViewById(R.id.text_pz_price);
        }
    }
}
