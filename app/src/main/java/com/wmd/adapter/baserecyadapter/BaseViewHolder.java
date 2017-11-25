package com.wmd.adapter.baserecyadapter;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * 时间：2017/11/23/17：18
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    protected final SparseArray<View> mViews;
    protected View mConvertView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
        mConvertView = itemView;
    }

    /**
     * 通过控件的Id获取对应的控件，如果没有则加入mViews，则从item根控件中查找并保存到mViews中
     *
     *
     * @param viewId get view resid
     * @return view
     */
    public <T extends View> T getView(@IdRes int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getmConvertView() {
        return mConvertView;
    }
}
