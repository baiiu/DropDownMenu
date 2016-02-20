package com.baiiu.filterdropdownmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.baiiu.filter.FilterDropDownMenu;
import com.baiiu.filter.interfaces.OnFilterDoneListener;
import com.baiiu.filterdropdownmenu.entity.FilterUrl;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnFilterDoneListener {

    @Bind(R.id.filterDropDownView)
    FilterDropDownMenu filterDropMenu;

    @Bind(R.id.mFilterContentView)
    TextView mFilterContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = ButterKnife.findById(this, R.id.toolbar);
        setSupportActionBar(toolbar);

        initFilterDropDownView();
    }

    private void initFilterDropDownView() {
        String[] titleList = new String[]{"第一个", "第二个", "第三个", "第四个"};
        filterDropMenu.setMenuAdapter(new FilterMenuAdapter(this, titleList, this));
    }

    @Override
    public void onFilterDone(int position, String positionTitle, String urlValue) {
        if (position != 3) {
            filterDropMenu.setPositionIndicatorText(FilterUrl.instance().position, FilterUrl.instance().positionTitle);
        }

        filterDropMenu.close();

        mFilterContentView.setText(FilterUrl.instance().toString());
    }
}
