package com.wb.baseadapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wubo
 * @date 2016/11/23 0023.
 */

public abstract class BaseRecyclerViewAdapter<T, H extends BaseHolder<T>> extends RecyclerView.Adapter<H> {

    protected List<T> datas;
    protected OnItemClickListener<T> listener;

    public BaseRecyclerViewAdapter(List<T> ts) {
        this.datas = ts;
        if (this.datas == null)
            datas = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(H holder, final int position) {
        holder.setData(datas.get(position));
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    listener.onItemClick(datas.get(position));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setOnItemClickListener(OnItemClickListener<T> listener){
        this.listener = listener;
    }

    public void setDatas(List<T> ts) {
        datas.clear();
        datas.addAll(ts);
        notifyDataSetChanged();
    }

    public void appendDatas(List<T> ts) {
        int start = datas.size();
        datas.addAll(ts);
        notifyItemRangeInserted(start, ts.size());
    }

    public void appendData(T t) {
        int start = datas.size();
        datas.add(t);
        notifyItemRangeChanged(start, 1);
    }

    public void preposeDatas(List<T> ts) {
        datas.addAll(0, ts);
        notifyItemRangeInserted(0, ts.size());
    }

    public void preposeData(T t) {
        datas.add(0, t);
        notifyItemRangeInserted(0, 1);
    }

    public void updateItem(int position, T t) {
        datas.set(position, t);
        notifyItemChanged(position);
    }

    public T getItemData(int position) {
        return datas.get(position);
    }
}
