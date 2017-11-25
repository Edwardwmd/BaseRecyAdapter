package com.wmd.adapter.baserecyadapter.listener;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 时间：2017/11/23/17：23
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：条目监听事件
 * 声明：版权归作者所有
 */

public interface OnItemClickListener {
    void setOnItemClickListener(View view, RecyclerView.ViewHolder holder, int position);
    boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position);
}
