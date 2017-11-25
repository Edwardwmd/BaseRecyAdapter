package com.wmd.adapter.baserecyadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmd.adapter.baserecyadapter.listener.OnItemClickListener;

/**
 * 时间：2017/11/23/17：22
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public abstract class BaseRecyAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private OnItemClickListener onItemClickListener;

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (onItemClickListener != null) {
            holder.getmConvertView().setClickable(true);
            holder.getmConvertView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.setOnItemClickListener(holder.getAdapterPosition());
                }
            });
        }
        onBindView(holder, holder.getAdapterPosition());
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutID(position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    protected abstract int getLayoutID(int position);

    public abstract void onBindView(BaseViewHolder holder, int adapterPosition);
}
