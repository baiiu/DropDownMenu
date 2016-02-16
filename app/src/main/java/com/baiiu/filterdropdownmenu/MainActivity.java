package com.baiiu.filterdropdownmenu;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.baiiu.filter.filter.FilterDropDownMenu;
import com.baiiu.filter.filter.interfaces.OnFilterDoneListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnFilterDoneListener {

    @Bind(R.id.filterDropDownView)
    FilterDropDownMenu filterDropMenu;

    SwipeRefreshLayout mRefreshLayout;
    RecyclerView mRecyclerView;
    private EmptyLayout emptyLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        View contentView = LayoutInflater.from(this).inflate(R.layout.include_refreshlist, null);
        mRefreshLayout = ButterKnife.findById(contentView, R.id.refreshLayout);
        mRecyclerView = ButterKnife.findById(contentView, R.id.recyclerView);
        emptyLayout = ButterKnife.findById(contentView, R.id.emptyLayout);

        filterDropMenu.setContentView(contentView);
        initFilterDropDownView();

    }


    private void initFilterDropDownView() {
        String[] titleList;
        titleList = new String[]{"全部公司", "爆发力", "行业", "筛选"};
        filterDropMenu.setMenuAdapter(new FilterMenuAdapter(this, titleList, this));
    }

    @Override
    public void onFilterDone(int position, String positionTitle, String urlValue) {

    }
}
