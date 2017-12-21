package com.example.acer.guanzhongwang;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 2017/12/15.
 */

public class LunBoAdapter extends PagerAdapter {


    Context context;
    List<Integer> list;
    Handler handler;
    public LunBoAdapter(Context context, List<Integer> list, Handler handler) {
        this.context=context;
        this.list=list;
        this.handler=handler;

    }


    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        //返回当前显示的视图
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(list.get(position%list.size()));

       // ImageLoader.getInstance().displayImage(String.valueOf(list.get(position%list.size())),imageView);
        //imageView触摸的监听事件
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                boolean isTiaoZhuan = true;


                switch (motionEvent.getAction()){//获取动作
                    case MotionEvent.ACTION_DOWN://按下
                        Log.i("--","ACTION_DOWN");
                        handler.removeCallbacksAndMessages(null);
                        break;
                    case MotionEvent.ACTION_MOVE://移动
                        Log.i("--","ACTION_MOVE");
                        isTiaoZhuan = false;
                        handler.removeCallbacksAndMessages(null);

                        break;
                    case MotionEvent.ACTION_CANCEL://取消
                        Log.i("--","ACTION_CANCEL");
                        isTiaoZhuan = false;
                        handler.sendEmptyMessageDelayed(0,2000);
                        break;
                    case MotionEvent.ACTION_UP://抬起
                        Log.i("--","ACTION_UP");
                        if (isTiaoZhuan){
                            Toast.makeText(context,"跳转页面",Toast.LENGTH_SHORT).show();

                            /*Intent intent = new Intent();


                            context.startActivity();*/
                        }
                        handler.sendEmptyMessageDelayed(0,2000);


                        break;
                }


                //自己处理触摸事件....如果当前位置返回了true,,,点击事件将不会执行,,,表示动作自己处理,不会传递
                return true;
            }
        });
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
