package com.bwie.xiaqin.shoppingmu.adapterr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.activity.AddDecreaseView;
import com.bwie.xiaqin.shoppingmu.bean.CarBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by lenovo on 2018/12/16.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    private Context context;
    private List<CarBean.ResultBean> list;

    public CarAdapter(Context context, List<CarBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }
    //接口回调
    public interface OnShopCartClickListener{
        void onShopCartClick(int position,boolean isChecked);
    }
    private OnShopCartClickListener listener;

    public void setOnShopCartClickListener(OnShopCartClickListener listener) {
        this.listener = listener;
    }
    public interface OnAddDecreaseListener{
        void onChang(int position,int num);
    }
    private OnAddDecreaseListener addListener;
    public void setOnAddDecreaseListener(OnAddDecreaseListener listener){
        this.addListener=listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.car_adapter_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mcarpic.setImageURI(list.get(position).getPic());
        holder.mcarcount.setText(list.get(position).getCommodityName());
        holder.mcarmoney.setText("￥："+list.get(position).getPrice());
        holder.productAdd.setNum(list.get(position).getCount());
        //加减器
        holder.productAdd.setOnAddClickListener(new AddDecreaseView.OnAddClickListener() {
            @Override
            public void add(int num) {
                list.get(position).setCount(num);
                if (addListener!=null){
                    addListener.onChang(position,num);

                }
            }

            @Override
            public void decrease(int num) {
                list.get(position).setCount(num);
                if (addListener!=null){
                    addListener.onChang(position,num);
                }
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.mcarbox.setOnCheckedChangeListener(null);
        holder.mcarbox.setChecked(list.get(position).isCheck());
        holder.mcarbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                list.get(position).setCheck(b);
                if (listener!=null){
                    listener.onShopCartClick(position,b);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox mcarbox;
        private AddDecreaseView productAdd;
        SimpleDraweeView mcarpic;
        TextView mcarcount, mcarmoney,mEtItemShopcartClothNum;
        ImageView delete;
        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);
            productAdd = itemView.findViewById(R.id.product_add);
            delete = itemView.findViewById(R.id.delete);
            mcarbox = itemView.findViewById(R.id.car_box);
            mcarpic = itemView.findViewById(R.id.car_pic);
            mcarcount = itemView.findViewById(R.id.car_count);
            mcarmoney = itemView.findViewById(R.id.car_money);
        }
    }
}
