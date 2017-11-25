package com.wmd.adapter.baserecyadapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2017/11/23/17：37
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public class MyAdapter extends BaseRecyAdapter {
    private List<ContBean> list = new ArrayList<>();
    private Context mC;

    public MyAdapter(Context context) {
        mC = context;
    }

    @Override
    protected int getLayoutID(int position) {
        return R.layout.item_1;
    }

    @Override
    public void onBindView(BaseViewHolder holder, int adapterPosition) {
        ImageView icon = (ImageView) holder.getView(R.id.icon);
        TextView name = (TextView) holder.getView(R.id.name);
        name.setText(list.get(adapterPosition).getTextName());
        Glide.with(holder.getmConvertView().getContext()).load(list.get(adapterPosition)).into(icon);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void setData(List<ContBean> contBeans) {
        list.clear();
        this.list = contBeans;
        notifyDataSetChanged();
    }
}
