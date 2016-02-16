package com.baiiu.filterdropdownmenu.entity;

import android.text.TextUtils;

/**
 * 描述：
 */
public class FilterUrl {
    private static FilterUrl filterUrl;

    private FilterUrl() {
    }

    public static FilterUrl get() {
        if (filterUrl == null) {
            synchronized (FilterUrl.class) {
                if (filterUrl == null) {
                    filterUrl = new FilterUrl();
                }
            }
        }
        return filterUrl;
    }

    public String position0Left;
    public String position0Right;
    public String position1;
    public String position2Left;
    public String position2Right;
    public String gridTop;
    public String gridBottom;

    public int position;
    public String positionTitle;

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        if (!TextUtils.isEmpty(position0Left)) {
            buffer.append("&position0Left=");
            buffer.append(position0Left);
            buffer.append("\n");
        }

        if (!TextUtils.isEmpty(position0Right)) {
            buffer.append("&position0Right=");
            buffer.append(position0Right);
            buffer.append("\n");
        }

        if (!TextUtils.isEmpty(position1)) {
            buffer.append("&position1=");
            buffer.append(position1);
            buffer.append("\n");
        }

        if (!TextUtils.isEmpty(position2Left)) {
            buffer.append("&position2Left=");
            buffer.append(position2Left);
            buffer.append("\n");
        }

        if (!TextUtils.isEmpty(position2Right)) {
            buffer.append("&position2Right=");
            buffer.append(position2Right);
            buffer.append("\n");
        }

        if (!TextUtils.isEmpty(gridTop)) {
            buffer.append("&gridTop=");
            buffer.append(gridTop);
            buffer.append("\n");
        }

        if (!TextUtils.isEmpty(gridBottom)) {
            buffer.append("&gridBottom=");
            buffer.append(gridBottom);
            buffer.append("\n");
        }

        return buffer.toString();
    }

    public void clear() {
        filterUrl = null;
    }


}