package com.wmd.adapter.baserecyadapter;

import android.content.Context;
import android.view.LayoutInflater;

import com.wmd.adapter.baserecyadapter.base.BaseRecyAdapter;
import com.wmd.adapter.baserecyadapter.base.BaseViewHolder;
import com.wmd.adapter.baserecyadapter.item.ItemViewDelegate;

import java.util.List;

/**
 * 时间：2017/11/25/15：24
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：RecyCommonAdapter
 * 声明：版权归作者所有
 */

public abstract class RecyCommonAdapter<T> extends BaseRecyAdapter<T> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public RecyCommonAdapter(Context context, final int layoutId, List<T> mDatas) {
        super(context, mDatas);
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        this.mDatas = mDatas;
        addItemViewDelegate(new ItemViewDelegate<T>() {
            @Override
            public boolean isForViewType(Object item, int position) {
                return true;
            }

            @Override
            public void convert(BaseViewHolder holder, T item, int position) {
                RecyCommonAdapter.this.convert(holder, item, position);
            }

            @Override
            public int getItemViewLayoutId() {
                return layoutId;
            }
        });
    }

    protected abstract void convert(BaseViewHolder holder, T t, int position);

}
