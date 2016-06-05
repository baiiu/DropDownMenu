package com.baiiu.dropdownmenu.view.betterDoubleGrid.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.baiiu.dropdownmenu.R;
import com.baiiu.filter.util.UIUtil;
import com.baiiu.filter.view.FilterCheckedTextView;

import butterknife.ButterKnife;

/**
 * auther: baiiu
 * time: 16/6/5 05 23:35
 * description:
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {

    private final FilterCheckedTextView textView;
    private View.OnClickListener mListener;

    public ItemViewHolder(Context mContext, ViewGroup parent, View.OnClickListener mListener) {
        super(UIUtil.infalte(mContext, R.layout.holder_item, parent));
        textView = ButterKnife.findById(itemView, R.id.tv_item);
        this.mListener = mListener;
    }


    public void bind(String s) {
        textView.setText(s);
        textView.setTag(s);
        textView.setOnClickListener(mListener);
    }
}
