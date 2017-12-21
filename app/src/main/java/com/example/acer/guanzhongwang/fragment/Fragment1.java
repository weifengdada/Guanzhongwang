package com.example.acer.guanzhongwang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acer.guanzhongwang.MainActivity;
import com.example.acer.guanzhongwang.MyFragmentPagerAdapter;
import com.example.acer.guanzhongwang.R;
import com.example.acer.guanzhongwang.SelActivity;
import com.zaaach.citypicker.CityPickerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * Created by acer on 2017/12/15.
 */

public class Fragment1 extends Fragment {

    @BindView(R.id.selCity)
    TextView selCity;
    @BindView(R.id.search)
    TextView search;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.tab_viewpager)
    ViewPager tabViewpager;
    Unbinder unbinder;
    private MyFragmentPagerAdapter fragmentPagerAdapter;
    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;
    private TabLayout.Tab five;
    private TabLayout.Tab six;
    private TabLayout.Tab seven;
    private TabLayout.Tab eight;
    private static final int REQUEST_CODE_PICK_CITY = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager());
        tabViewpager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(tabViewpager);
        one = tabLayout.getTabAt(0);
        two = tabLayout.getTabAt(1);
        three = tabLayout.getTabAt(2);
        four = tabLayout.getTabAt(3);
        five = tabLayout.getTabAt(4);
        six = tabLayout.getTabAt(5);
        seven = tabLayout.getTabAt(6);
        eight = tabLayout.getTabAt(7);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SelActivity.class));
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.selCity)
    public void onViewClicked() {

//启动
        startActivityForResult(new Intent(getActivity(), CityPickerActivity.class),
                REQUEST_CODE_PICK_CITY);

    }
    //重写onActivityResult方法
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK){
            if (data != null){
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                selCity.setText("当前选择：" + city);
            }
        }
    }


}
