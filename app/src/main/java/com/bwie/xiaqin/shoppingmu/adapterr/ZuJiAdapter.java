package com.bwie.xiaqin.shoppingmu.adapterr;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.bean.ZuJiBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by lenovo on 2018/12/19.
 */

public class ZuJiAdapter extends RecyclerView.Adapter<ZuJiAdapter.ViewHolder>{
    private Context context;
    private List<ZuJiBean.ResultBean> mList;

    public ZuJiAdapter(Context context, List<ZuJiBean.ResultBean> list) {
        this.context = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.wo_zu_foot,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        //设置数据
        ZuJiBean.ResultBean resultBean = mList.get(i);
        Glide.with(context).load(resultBean.getMasterPic()).into(viewHolder.imageView);
        viewHolder.mc.setText(resultBean.getCommodityName());
        viewHolder.price.setText("￥"+resultBean.getPrice());
        viewHolder.ll.setText("已浏览:"+resultBean.getBrowseNum());
        //设置时间
        long browseTime = resultBean.getBrowseTime();
        Date date = new Date(browseTime);//时间管理类
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());//格式
        viewHolder.date.setText(format.format(date));//设置时间

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView imageView;
        private final TextView mc;
        private final TextView price;
        private final TextView ll;
        private final TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.myfoot_adapter_imageview_image);
            mc = itemView.findViewById(R.id.myfoot_adapter_textview_mc);
            price = itemView.findViewById(R.id.myfoot_adapter_textview_price);
            ll = itemView.findViewById(R.id.myfoot_adapter_textview_ll);
            date = itemView.findViewById(R.id.myfoot_adapter_textview_data);
        }
    }
}
