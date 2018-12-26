package com.bwie.xiaqin.shoppingmu.adapterr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.bean.QuanBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.lang.annotation.ElementType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/12/12.
 */

public class QuanAdapter extends RecyclerView.Adapter<QuanAdapter.ViewHolder> {

    private Context context;
    private List<QuanBean.ResultBean> list;

    public QuanAdapter(Context context, List<QuanBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    int num=0;
//    private final int INTEM_ONE = 0;
//    private final int INTEM_TWO = 1;
//    private final int INTEM_THREE = 2;
//    private final int INTEM_FOUR = 3;

//    @Override
//    public int getItemViewType(int position) {
//        int i = list.get(position).getImage().length();
//        if (i==INTEM_ONE && i!=INTEM_TWO && i !=INTEM_THREE &&i !=INTEM_FOUR){
//            return INTEM_ONE;
//        }else if (i !=INTEM_ONE && i == INTEM_TWO && i !=INTEM_THREE && i !=INTEM_FOUR){
//            return INTEM_TWO;
//        }else if (i !=INTEM_ONE && i != INTEM_TWO && i ==INTEM_THREE && i !=INTEM_FOUR){
//            return INTEM_THREE;
//        }else if (i !=INTEM_ONE && i != INTEM_TWO && i !=INTEM_THREE && i ==INTEM_FOUR){
//            return INTEM_FOUR;
//        }else {
//            return INTEM_ONE;
//        }
//
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.quan_adapter_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(list.get(position).getHeadPic()).into(holder.heads);
        holder.headsname.setText(String.valueOf(list.get(position).getNickName()));
        holder.times.setText(String.valueOf(list.get(position).getCreateTime()));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse = format.parse(list.get(position).getCreateTime());
            holder.times.setText(parse+"");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.titles.setText(list.get(position).getContent());
        Glide.with(context).load(list.get(position).getImage()).into(holder.img1);
        Glide.with(context).load(list.get(position).getImage()).into(holder.img2);
        holder.diannum.setText(String.valueOf(list.get(position).getGreatNum()));
        final SimpleDraweeView diansan = holder.diansan;
        final TextView diannum = holder.diannum;
        diansan.setOnClickListener(new View.OnClickListener() {
            @Override
            //点赞

            public void onClick(View v) {
                diansan.setImageResource(R.mipmap.quan_bian_btn_prise_s_hdpi);
//                diannum.setText(num+1+"");
                diannum.setText(String.valueOf(list.get(position).getGreatNum()+1));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView heads;
        TextView headsname;
        TextView times;
        TextView titles;
        SimpleDraweeView img1;
        SimpleDraweeView img2;
        SimpleDraweeView diansan;
        SimpleDraweeView diansans;
        TextView diannum;

        public ViewHolder(View itemView) {
            super(itemView);
            heads = itemView.findViewById(R.id.cicrcle_drawview_head_portrait);
            headsname = itemView.findViewById(R.id.cicrcle_text_name);
            times = itemView.findViewById(R.id.cicrcle_text_time);
            titles = itemView.findViewById(R.id.cicrcle_text_title);
            img1 = itemView.findViewById(R.id.cicrcle_drawview_comment1);
            img2 = itemView.findViewById(R.id.cicrcle_drawview_comment2);
            diansan = itemView.findViewById(R.id.cicrcle_drawview_dianzan);
            diansans = itemView.findViewById(R.id.cicrcle_drawview_dianzans);
            diannum = itemView.findViewById(R.id.cicrcle_text_dianzannum);
        }
    }



}
