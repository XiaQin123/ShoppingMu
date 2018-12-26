package com.bwie.xiaqin.shoppingmu.fragment;

;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.xiaqin.shoppingmu.R;
import com.bwie.xiaqin.shoppingmu.adapterr.CarAdapter;
import com.bwie.xiaqin.shoppingmu.bean.CarBean;
import com.bwie.xiaqin.shoppingmu.mvp.car.presenter.CarPresenter;
import com.bwie.xiaqin.shoppingmu.mvp.car.view.CarView;

import java.util.ArrayList;
import java.util.List;

public class CarFragment extends Fragment implements CarView{
    public static final String BUNDLE_TITLE = "title";

    private RecyclerView mcarre;
    private List<CarBean.ResultBean> carlist = new ArrayList<>();
    private CarAdapter carAdapter;
    private CarPresenter presenter;
    private CheckBox check_box;
    private TextView total;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.car_fragment, container, false);
        mcarre = view.findViewById(R.id.car_re);
        check_box = view.findViewById(R.id.check_box);
        total = view.findViewById(R.id.total);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        carAdapter = new CarAdapter(getActivity(), carlist);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mcarre.setAdapter(carAdapter);
        mcarre.setLayoutManager(manager);
        presenter = new CarPresenter();
        presenter.attach(this);
        presenter.ShopCar();
        check_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = check_box.isChecked();
                for (CarBean.ResultBean resultBean : carlist){
                    resultBean.setCheck(checked);
                }
                carAdapter.notifyDataSetChanged();
                caclulatePrice();
            }
        });
        carAdapter.setOnShopCartClickListener(new CarAdapter.OnShopCartClickListener() {
            @Override
            public void onShopCartClick(int position, boolean isChecked) {
                if (!isChecked){
                    check_box.setChecked(false);
                }else {
                    boolean isAllSelected = true;
                    for (CarBean.ResultBean resultBean : carlist){
                        if (!resultBean.isCheck()){
                            isAllSelected = false;
                            break;
                        }
                    }
                    check_box.setChecked(isAllSelected);
                    carAdapter.notifyDataSetChanged();
                }
                caclulatePrice();
            }
        });
        carAdapter.setOnAddDecreaseListener(new CarAdapter.OnAddDecreaseListener() {
            @Override
            public void onChang(int position, int num) {
                caclulatePrice();
            }
        });
    }

    private void caclulatePrice() {
        float price = 0;
        for (CarBean.ResultBean resultBean : carlist){
            if (resultBean.isCheck()){
                price += resultBean.getPrice() * resultBean.getCount();
            }
        }
        total.setText(price+"");
    }

    @Override
    public void onShopCar(CarBean data) {
        if (data!=null){
            carlist.addAll(data.getResult());
        }
        Toast.makeText(getActivity(), "成功", Toast.LENGTH_SHORT).show();
        carAdapter.notifyDataSetChanged();
    }

    @Override
    public void onShopCarFaile(Exception msg) {
        Toast.makeText(getActivity(), "失败", Toast.LENGTH_SHORT).show();
    }
    public static CarFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        CarFragment fragment = new CarFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.onDestroy();
        }
    }


}
