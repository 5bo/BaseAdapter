package com.wb.baseadapter.recyclerview;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author wubo
 * @date 2016/11/23 0023.
 */

public abstract class BaseHolder<T> extends RecyclerView.ViewHolder {

    public BaseHolder(ViewGroup parent, @LayoutRes int resId) {
        super(LayoutInflater.from(parent.getContext()).inflate(resId, parent, false));
    }

    /**
     * 获取布局中的子View
     * @param resId view的id
     * @param <V> view的类型
     * @return view
     */
    protected <V extends View> V findViewById(@IdRes int resId) {
        return (V) itemView.findViewById(resId);
    }

    /**
     * 设置数据
     * @param t 要显示的数据
     */
    public abstract void setData(T t);
}
