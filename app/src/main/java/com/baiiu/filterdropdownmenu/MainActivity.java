package com.baiiu.filterdropdownmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.baiiu.filter.FilterDropDownMenu;
import com.baiiu.filter.interfaces.OnFilterDoneListener;
import com.baiiu.filterdropdownmenu.entity.FilterUrl;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnFilterDoneListener {

    @Bind(R.id.filterDropDownView)
    FilterDropDownMenu filterDropMenu;

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        View contentView = LayoutInflater.from(this).inflate(R.layout.include_refreshlist, null);
        filterDropMenu.setContentView(contentView);

        textView = ButterKnife.findById(contentView, R.id.text);
        initFilterDropDownView();
    }


    private void initFilterDropDownView() {

        String[] titleList = new String[]{"第一个", "第二个", "第三个", "第四个"};
        filterDropMenu.setMenuAdapter(new FilterMenuAdapter(this, titleList, this));
    }

    @Override
    public void onFilterDone(int position, String positionTitle, String urlValue) {
        filterDropMenu.setPositionIndicatorText(FilterUrl.instance().position, FilterUrl.instance().positionTitle);
        filterDropMenu.close();

        textView.setText(FilterUrl.instance().toString());
    }
}
