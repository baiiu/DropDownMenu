package com.baiiu.filter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baiiu.filter.R;
import com.baiiu.filter.util.UIUtil;
import com.baiiu.filter.view.FilterCheckedTextView;

import java.util.List;

/**
 * Created by baiiu on 15/12/23.
 * 菜单条目适配器
 */
public abstract class SimpleTextAdapter<T> extends BaseBaseAdapter<T> {

    private final LayoutInflater inflater;

    public SimpleTextAdapter(List<T> list, Context context) {
        super(list, context);
        inflater = LayoutInflater.from(context);
    }

    public static class FilterItemHolder {
        FilterCheckedTextView checkedTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FilterItemHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.lv_item_filter, parent, false);

            holder = new FilterItemHolder();
            holder.checkedTextView = (FilterCheckedTextView) convertView;
            holder.checkedTextView.setPadding(0, UIUtil.dp(context, 15), 0, UIUtil.dp(context, 15));
            initCheckedTextView(holder.checkedTextView);

            convertView.setTag(holder);
        } else {
            holder = (FilterItemHolder) convertView.getTag();
        }

        T t = list.get(position);
        holder.checkedTextView.setText(provideText(t));

        return convertView;
    }

    public abstract String provideText(T t);

    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
    }


}
