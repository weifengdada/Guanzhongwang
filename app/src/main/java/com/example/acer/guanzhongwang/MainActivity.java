package com.example.acer.guanzhongwang;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.acer.guanzhongwang.fragment.Fragment1;
import com.example.acer.guanzhongwang.fragment.Fragment2;
import com.example.acer.guanzhongwang.fragment.Fragment3;
import com.example.acer.guanzhongwang.fragment.Fragment4;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.huodong)
    RadioButton huodong;
    @BindView(R.id.fabu)
    RadioButton fabu;
    @BindView(R.id.guanli)
    RadioButton guanli;
    @BindView(R.id.wode)
    RadioButton wode;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
           Fragment fragment=null;
           @Override
           public Fragment getItem(int position) {
               switch (position){
                   case 0:
                       fragment=new Fragment1();
                     break;
                   case 1:
                       fragment=new Fragment2();
                       break;
                   case 2:
                       fragment=new Fragment3();
                       break;
                   case 3:
                       fragment=new Fragment4();

                       break;
               }

           return fragment;

           }

           @Override
           public int getCount() {
               return 4;
           }
       });
       viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
               radioGroup.check(radioGroup.getChildAt(position).getId());
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @OnClick({R.id.huodong, R.id.fabu, R.id.guanli, R.id.wode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.huodong:
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.fabu:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.guanli:
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.wode:
                viewPager.setCurrentItem(3,false);
                break;
        }
    }


}
