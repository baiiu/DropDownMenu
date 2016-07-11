package com.baiiu.filter.typeview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.baiiu.filter.adapter.BaseBaseAdapter;
import com.baiiu.filter.interfaces.OnFilterItemClickListener;
import com.baiiu.filter.util.CommonUtil;
import com.baiiu.filter.util.UIUtil;

import java.util.List;

/**
 * author: baiiu
 * date: on 16/2/16 15:46
 * description:
 */
public class SingleGridView<DATA> extends GridView implements AdapterView.OnItemClickListener {

    private BaseBaseAdapter<DATA> mAdapter;
    private OnFilterItemClickListener<DATA> mOnItemClickListener;

    public SingleGridView(Context context) {
        this(context, null);
    }

    public SingleGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SingleGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        setSelector(new ColorDrawable(Color.TRANSPARENT));
        setNumColumns(3);
        setBackgroundColor(Color.WHITE);
        setSmoothScrollbarEnabled(false);


        int dp = UIUtil.dp(context, 15);

        setVerticalSpacing(dp);
        setHorizontalSpacing(dp);
        setPadding(dp, dp, dp, dp);

        setOnItemClickListener(this);
    }

    public SingleGridView<DATA> adapter(BaseBaseAdapter<DATA> adapter) {
        this.mAdapter = adapter;
        setAdapter(adapter);
        return this;
    }

    public SingleGridView<DATA> onItemClick(OnFilterItemClickListener<DATA> onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
        return this;
    }


    public void setList(List<DATA> list, int checkedPositoin) {
        mAdapter.setList(list);

        if (checkedPositoin != -1) {
            setItemChecked(checkedPositoin, true);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (CommonUtil.isFastDoubleClick()) {
            return;
        }

        DATA item = mAdapter.getItem(position);

        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(item);
        }
    }


}
