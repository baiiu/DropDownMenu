package com.baiiu.filter.filter.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * author: baiiu
 * date: on 16/2/16 13:55
 * description:
 */
public class UIUtil {

    public static int dp(Context context, int dp) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, context.getResources().getDisplayMetrics()) + 0.5F);
    }

}
