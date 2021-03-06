package com.yoyo.yoappmanage.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T, L extends BaseRecyclerViewViewHolder> extends RecyclerView.Adapter<L> {
    protected List<T> mData = new ArrayList<>();
    public List<Object> clickGray = new ArrayList<>();//点击变色
    OnBaseRecyclerViewListener onRecyclerViewListener;

    public BaseAdapter(@NonNull List<T> mData,OnBaseRecyclerViewListener onBaseRecyclerViewListener) {
        if(mData==null){
            mData = new ArrayList<>();
        }
        if(onBaseRecyclerViewListener!=null){
            this.onRecyclerViewListener=onBaseRecyclerViewListener;
        }
        this.mData = mData;
    }

    public void setOnRecyclerViewListener(OnBaseRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public T getItem(int position) {
        return mData.get(position);
    }

    public void addData(@NonNull List<T> list) {
        if(list==null){
            return;
        }
        this.mData.addAll(list);
    }

    public void clearData() {
        this.mData.clear();
        this.clickGray.clear();
    }

    public List<T> getmData() {
        return mData;
    }

    public void setmData(@NonNull List<T> mData) {
        if(mData==null){
            mData = new ArrayList<>();
        }
        this.mData = mData;
    }

    @Override
    public L onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(L holder, int position) {
        holder.position=position;
        if(onRecyclerViewListener!=null){
            holder.onRecyclerViewListener=onRecyclerViewListener;
        }
    }
}


