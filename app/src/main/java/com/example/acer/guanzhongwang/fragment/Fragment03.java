package com.example.acer.guanzhongwang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.guanzhongwang.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by acer on 2017/12/15.
 */

public class Fragment03 extends Fragment {
    @BindView(R.id.a1)
    ImageView a1;
    @BindView(R.id.b1)
    TextView b1;
    @BindView(R.id.a2)
    ImageView a2;
    @BindView(R.id.b2)
    TextView b2;
    @BindView(R.id.a3)
    ImageView a3;
    @BindView(R.id.b3)
    TextView b3;
    @BindView(R.id.a4)
    ImageView a4;
    @BindView(R.id.b4)
    TextView b4;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment03, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
