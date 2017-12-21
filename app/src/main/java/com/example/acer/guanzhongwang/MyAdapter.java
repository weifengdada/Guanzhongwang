package com.example.acer.guanzhongwang;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by acer on 2017/12/15.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int LUNBO = 0;
    int DAOHANG = 1;
    int DATA = 2;
    Context context;
    private List<Integer> list;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                int currentItem = holder1.lunboViewpager.getCurrentItem();
                holder1.lunboViewpager.setCurrentItem(currentItem + 1);
                handler.sendEmptyMessageDelayed(0, 2000);
            }
        }
    };
    private LunBoViewHolder holder1;

    public MyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == LUNBO) {
            View view = View.inflate(context, R.layout.lunbo_layout, null);
            return new LunBoViewHolder(view);
        } else if (viewType == DAOHANG) {
            View view = View.inflate(context, R.layout.daohang_layout, null);

            return new DaoHangViewHolder(view);
        } else {
            View view = View.inflate(context, R.layout.data_layout, null);
            return new DataViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return LUNBO;

        } else if (position == 1) {

            return DAOHANG;
        } else {
            return DATA;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof LunBoViewHolder) {
            holder1 = (LunBoViewHolder) holder;
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(R.drawable.dilireba);
            list.add(R.drawable.zhangzifeng);
            list.add(R.drawable.piaoxinhui);
            //   notifyDataSetChanged();

            // ((LunBoViewHolder) holder).lunboViewpager.set
            LunBoAdapter lunBoAdapter = new LunBoAdapter(context, list, handler);
            ((LunBoViewHolder) holder).lunboViewpager.setAdapter(lunBoAdapter);
            ((LunBoViewHolder) holder).lunboViewpager.setCurrentItem(list.size() * 1000);
            handler.sendEmptyMessageDelayed(0, 2000);
        } else if (holder instanceof DaoHangViewHolder) {

            ((DaoHangViewHolder) holder).imageA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "热门", Toast.LENGTH_SHORT).show();
                }
            });
            ((DaoHangViewHolder) holder).imageB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "附近", Toast.LENGTH_SHORT).show();
                }
            });
            ((DaoHangViewHolder) holder).imageC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "日期", Toast.LENGTH_SHORT).show();
                }
            });


        } else if (holder instanceof DataViewHolder) {


        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    static class LunBoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.lunbo_viewpager)
        ViewPager lunboViewpager;

        LunBoViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    static class DaoHangViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_a)
        Button imageA;
        @BindView(R.id.image_b)
        Button imageB;
        @BindView(R.id.image_c)
        Button imageC;

        DaoHangViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    static class DataViewHolder extends RecyclerView.ViewHolder {
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

        DataViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
