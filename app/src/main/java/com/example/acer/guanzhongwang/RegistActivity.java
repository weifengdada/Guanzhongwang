package com.example.acer.guanzhongwang;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistActivity extends AppCompatActivity {

    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.regist_mobile)
    EditText registMobile;
    @BindView(R.id.regist_password)
    EditText registPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);
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
    @OnClick({R.id.fanhui, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                 finish();
                break;
            case R.id.btn_login:
                String mobile = registMobile.getText().toString();
                String password = registPassword.getText().toString();
                if (!TextUtils.isEmpty(mobile) & !TextUtils.isEmpty(password)) {
                    startActivity(new Intent(this, MainActivity.class));
                }
                break;
        }
    }
}
