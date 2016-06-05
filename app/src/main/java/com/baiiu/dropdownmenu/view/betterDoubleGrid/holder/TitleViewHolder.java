package com.baiiu.dropdownmenu.view.betterDoubleGrid.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baiiu.dropdownmenu.R;
import com.baiiu.filter.util.UIUtil;

/**
 * auther: baiiu
 * time: 16/6/5 05 23:30
 * description:
 */
public class TitleViewHolder extends RecyclerView.ViewHolder {

    public TitleViewHolder(Context mContext, ViewGroup parent) {
        super(UIUtil.infalte(mContext, R.layout.holder_title, parent));
    }


    public void bind(String s) {
        ((TextView) itemView).setText(s);
    }
}
