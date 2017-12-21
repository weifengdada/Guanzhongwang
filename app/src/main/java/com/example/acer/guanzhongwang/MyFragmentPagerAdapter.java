package com.example.acer.guanzhongwang;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.acer.guanzhongwang.fragment.Fragment01;
import com.example.acer.guanzhongwang.fragment.Fragment02;
import com.example.acer.guanzhongwang.fragment.Fragment03;
import com.example.acer.guanzhongwang.fragment.Fragment04;
import com.example.acer.guanzhongwang.fragment.Fragment05;
import com.example.acer.guanzhongwang.fragment.Fragment06;
import com.example.acer.guanzhongwang.fragment.Fragment07;
import com.example.acer.guanzhongwang.fragment.Fragment08;

/**
 * Created by acer on 2017/12/15.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"全部", "综艺娱乐", "财经访谈","文化旅游","时尚体育", "青少科教", "养生保健","公益"};

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new Fragment02();
        } else if (position == 2) {
            return new Fragment03();
        }else if (position==3){
            return new Fragment04();
        }else if (position == 4) {
            return new Fragment05();
        } else if (position == 5) {
            return new Fragment06();
        }else if (position==6){
            return new Fragment07();
        }else if (position==7){
            return new Fragment08();
        }
        return new Fragment01();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
