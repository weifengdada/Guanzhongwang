package com.example.acer.guanzhongwang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.guanzhongwang.AdminsWantAdapter;
import com.example.acer.guanzhongwang.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by acer on 2017/12/16.
 */

public class FragmentBaoming extends Fragment{
    @BindView(R.id.admins_tab)
    TabLayout adminsTab;
    @BindView(R.id.admins_want_viewpager)
    ViewPager adminsWantViewpager;
    Unbinder unbinder;
    private List<String> title;
    private List<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.baoming, null);
        unbinder = ButterKnife.bind(this, view);
        adminsTab.addTab(adminsTab.newTab().setText("待审核"), true);
        adminsTab.addTab(adminsTab.newTab().setText("待支付"), false);
        adminsTab.addTab(adminsTab.newTab().setText("待参加"), false);
        adminsTab.addTab(adminsTab.newTab().setText("已完成"), false);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = new ArrayList<>();
        list.add(new FragAdminsWaitCheck());
        list.add(new FragAdminsWaitPay());
        list.add(new FragAdminsWaitJion());
        list.add(new FragAdminsFinish());
        title = new ArrayList<>();
        title.add("待审核");
        title.add("待支付");
        title.add("待参加");
        title.add("已完成");
        AdminsWantAdapter wantAdapter = new AdminsWantAdapter(getChildFragmentManager(), list, title);
        adminsWantViewpager.setAdapter(wantAdapter);
        adminsTab.setupWithViewPager(adminsWantViewpager);
        adminsWantViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

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
}
