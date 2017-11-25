package com.wmd.adapter.baserecyadapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.wmd.adapter.baserecyadapter.item.ItemViewDelegate;
import com.wmd.adapter.baserecyadapter.item.ItemViewManager;
import com.wmd.adapter.baserecyadapter.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2017/11/23/17：22
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：RecycleView Adapter 的基类
 * 声明：版权归作者所有
 */

public class BaseRecyAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    protected OnItemClickListener onItemClickListener;
    protected Context mC;
    protected List<T> mDatas = new ArrayList<T>();
    protected ItemViewManager mItemViewManager;


    public BaseRecyAdapter(Context context, List<T> mDatas) {
        mC = context;
        mItemViewManager = new ItemViewManager();
        this.mDatas.clear();
        this.mDatas.addAll(mDatas);
        notifyDataSetChanged();
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemViewDelegate itemViewDelegate = mItemViewManager.getItemViewDelegate(viewType);
        BaseViewHolder holder = BaseViewHolder.createViewHolder(mC, parent, itemViewDelegate.getItemViewLayoutId());
        onViewHolderCreated(holder, holder.getmConvertView());
        setListener(parent, holder, viewType);
        return holder;
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        convert(holder, mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (!useItemViewManager()) return super.getItemViewType(position);
        return mItemViewManager.getItemViewType(mDatas.get(position), position);
    }

    private boolean useItemViewManager() {
        return mItemViewManager.getItemViewCount() > 0;
    }

    public void convert(BaseViewHolder holder, T item) {
        mItemViewManager.convert(holder, item, holder.getAdapterPosition());
    }

    public void onViewHolderCreated(BaseViewHolder holder, View item) {

    }

    protected void setListener(final ViewGroup parent, final BaseViewHolder viewHolder, int viewType) {
        if (!isEnabled(viewType)) return;
        viewHolder.getmConvertView().setOnClickListener(v -> {
            if (onItemClickListener != null) {
                int position = viewHolder.getAdapterPosition();
                onItemClickListener.setOnItemClickListener(v, viewHolder, position);
            }
        });

        viewHolder.getmConvertView().setOnLongClickListener(v -> {
            if (onItemClickListener != null) {
                int position = viewHolder.getAdapterPosition();
                return onItemClickListener.onItemLongClick(v, viewHolder, position);
            }
            return false;
        });
    }

    protected boolean isEnabled(int viewType) {
        return true;
    }

    public List<T> getDatas() {
        return mDatas;
    }

    public BaseRecyAdapter addItemViewDelegate(ItemViewDelegate<T> itemViewDelegate) {
        mItemViewManager.addDelegate(itemViewDelegate);
        return this;
    }

    public BaseRecyAdapter addItemViewDelegate(int viewType, ItemViewDelegate<T> itemViewDelegate) {
        mItemViewManager.addDelegate(viewType, itemViewDelegate);
        return this;
    }

}
