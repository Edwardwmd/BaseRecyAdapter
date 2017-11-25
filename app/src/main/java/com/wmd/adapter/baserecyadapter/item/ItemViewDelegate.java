package com.wmd.adapter.baserecyadapter.item;

import com.wmd.adapter.baserecyadapter.base.BaseViewHolder;

/**
 * 时间：2017/11/25/14：53
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public interface ItemViewDelegate<T> {

    boolean isForViewType(T item, int position);

    void convert(BaseViewHolder holder, T item, int position);

    int getItemViewLayoutId();
}
