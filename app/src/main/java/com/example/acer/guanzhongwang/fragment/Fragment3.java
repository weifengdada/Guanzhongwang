package com.example.acer.guanzhongwang.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.acer.guanzhongwang.Fragment3Adapter;
import com.example.acer.guanzhongwang.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by acer on 2017/12/15.
 */

public class Fragment3 extends Fragment {

    @BindView(R.id.mybaoming)
    RadioButton mybaoming;
    @BindView(R.id.mysend)
    RadioButton mysend;
    @BindView(R.id.admins_viewpager)
    ViewPager adminsViewpager;
    Unbinder unbinder;
    private List<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        SharedPreferences sp = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);


        if (sp.getBoolean("isLogin", false)) {

            Toast.makeText(getActivity(), "登录", Toast.LENGTH_SHORT).show();
            mysend.setVisibility(ViewPager.GONE);

        }else{
            Toast.makeText(getActivity(), "未登录", Toast.LENGTH_SHORT).show();



        }


        list = new ArrayList<>();
        list.add(new FragmentBaoming());
        list.add(new Fragment());
        Fragment3Adapter pagerAdapter = new Fragment3Adapter(getFragmentManager(), list);
        adminsViewpager.setAdapter(pagerAdapter);
        adminsViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    mybaoming.setChecked(true);
                }
                if (position == 1) {
                    mysend.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mybaoming, R.id.mysend})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mybaoming:
                adminsViewpager.setCurrentItem(0);
                break;
            case R.id.mysend:
                adminsViewpager.setCurrentItem(1);
                break;
        }
    }
}
