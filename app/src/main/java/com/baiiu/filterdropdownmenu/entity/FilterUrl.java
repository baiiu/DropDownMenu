package com.baiiu.filterdropdownmenu.entity;

import android.text.TextUtils;

/**
 * 描述：
 */
public class FilterUrl {
    private volatile static FilterUrl filterUrl;

    private FilterUrl() {
    }

    public static FilterUrl instance() {
        if (filterUrl == null) {
            synchronized (FilterUrl.class) {
                if (filterUrl == null) {
                    filterUrl = new FilterUrl();
                }
            }
        }
        return filterUrl;
    }

    public String position0;
    public String position1Left;
    public String position1Right;
    public String positionGrid;
    public String gridTop;
    public String gridBottom;

    public int position;
    public String positionTitle;

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        if (!TextUtils.isEmpty(position0)) {
            buffer.append("position0Left=");
            buffer.append(position);
            buffer.append("\n");
        }


        if (!TextUtils.isEmpty(position1Left)) {
            buffer.append("position1=");
            buffer.append(position1Left);
            buffer.append("\n");
        }

        if (!TextUtils.isEmpty(position1Right)) {
            buffer.append("position2=");
            buffer.append(position1Right);
            buffer.append("\n");
        }

        if (!TextUtils.isEmpty(positionGrid)) {
            buffer.append("position2=");
            buffer.append(positionGrid);
            buffer.append("\n");
        }

        if (!TextUtils.isEmpty(gridTop)) {
            buffer.append("gridTop=");
            buffer.append(gridTop);
            buffer.append("\n");
        }

        if (!TextUtils.isEmpty(gridBottom)) {
            buffer.append("gridBottom=");
            buffer.append(gridBottom);
            buffer.append("\n");
        }

        return buffer.toString();
    }

    public void clear() {
        filterUrl = null;
    }


}