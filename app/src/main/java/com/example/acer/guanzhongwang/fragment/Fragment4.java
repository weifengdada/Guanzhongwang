package com.example.acer.guanzhongwang.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.acer.guanzhongwang.LoginActivity;
import com.example.acer.guanzhongwang.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by acer on 2017/12/15.
 */

public class Fragment4 extends Fragment {


    @BindView(R.id.login_image)
    ImageView loginImage;
    Unbinder unbinder;
    @BindView(R.id.login)
    ImageView login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment4, container, false);

        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        SharedPreferences sp = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);


        if (sp.getBoolean("isLogin", false)) {

            login.setVisibility(View.VISIBLE);
            loginImage.setVisibility(View.GONE);
        }else{


        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick(R.id.login_image)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }
}
