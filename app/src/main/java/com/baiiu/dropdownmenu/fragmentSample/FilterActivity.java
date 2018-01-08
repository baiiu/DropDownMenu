package com.baiiu.dropdownmenu.fragmentSample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * author: baiiu
 * date: on 18/1/8 11:56
 * description:
 */
public class FilterActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new FilterFragment(), FilterFragment.class.getCanonicalName())
                .commitAllowingStateLoss();
    }

}
