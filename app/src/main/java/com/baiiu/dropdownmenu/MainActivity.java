package com.baiiu.dropdownmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.baiiu.dropdownmenu.entity.FilterUrl;
import com.baiiu.dropdownmenu.fragmentSample.FilterActivity;
import com.baiiu.filter.DropDownMenu;
import com.baiiu.filter.interfaces.OnFilterDoneListener;

public class MainActivity extends AppCompatActivity implements OnFilterDoneListener, View.OnClickListener {

    @BindView(R.id.dropDownMenu) DropDownMenu dropDownMenu;
    @BindView(R.id.mFilterContentView) TextView mFilterContentView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = ButterKnife.findById(this, R.id.toolbar);
        setSupportActionBar(toolbar);

        initFilterDropDownView();

        mFilterContentView.setOnClickListener(this);
    }

    private void initFilterDropDownView() {
        String[] titleList = new String[] { "第一个", "第二个", "第三个", "第四个" };
        dropDownMenu.setMenuAdapter(new DropMenuAdapter(this, titleList, this));
    }

    @Override public void onFilterDone(int position, String positionTitle, String urlValue) {
        if (position != 3) {
            dropDownMenu.setPositionIndicatorText(FilterUrl.instance().position, FilterUrl.instance().positionTitle);
        }

        dropDownMenu.close();
        mFilterContentView.setText(FilterUrl.instance()
                                           .toString());
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        FilterUrl.instance()
                .clear();
    }

    @Override public void onClick(View view) {
        startActivity(new Intent(this, FilterActivity.class));
    }

}
