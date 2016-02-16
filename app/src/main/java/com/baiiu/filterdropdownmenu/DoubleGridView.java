package com.baiiu.filterdropdownmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.baiiu.filter.filter.adapter.SubMenuAdapter;
import com.baiiu.filter.filter.interfaces.OnFilterDoneListener;
import com.baiiu.filter.filter.util.CommonUtil;
import com.baiiu.filter.filter.util.UIUtil;
import com.baiiu.filter.filter.view.FilterCheckedTextView;
import com.baiiu.filterdropdownmenu.entity.FilterType;
import com.baiiu.filterdropdownmenu.entity.FilterUrl;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by baiiu on 15/12/22.
 * 筛选器GridView
 */
public class DoubleGridView extends ScrollView implements View.OnClickListener {

    @Bind(R.id.grid_top)
    GridViewInScrollView mTopGrid;

    @Bind(R.id.iv_expand)
    ImageView iv_expand;

    @Bind(R.id.grid_bottom)
    GridViewInScrollView mBottomGrid;

    @Bind(R.id.bt_confirm)
    Button bt_confirm;

    private SubMenuAdapter<FilterType> mTopAdapter;
    private SubMenuAdapter<FilterType> mBottomAdapter;


    public DoubleGridView(Context context) {
        this(context, null);
    }

    public DoubleGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        View view = inflate(context, R.layout.merge_filter_third, this);
        setBackgroundResource(android.R.color.white);

        ButterKnife.bind(this, view);

        iv_expand.setOnClickListener(this);
        bt_confirm.setOnClickListener(this);

        initAdapter(context);

        mTopGrid.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        mBottomGrid.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        mTopGrid.setAdapter(mTopAdapter);
        mBottomGrid.setAdapter(mBottomAdapter);
    }

    private void initAdapter(Context context) {

        mTopAdapter = new SubMenuAdapter<FilterType>(null, context) {
            @Override
            public String provideText(FilterType phase) {
                return phase.desc;
            }

            @Override
            protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                checkedTextView.setPadding(0, UIUtil.dp(context, 3), 0, UIUtil.dp(context, 3));
                checkedTextView.setGravity(Gravity.CENTER);
                checkedTextView.setBackgroundResource(R.drawable.selector_filter_grid);
            }
        };


        mBottomAdapter = new SubMenuAdapter<FilterType>(null, context) {
            @Override
            public String provideText(FilterType area) {
                return area.desc;
            }

            @Override
            protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                checkedTextView.setPadding(0, UIUtil.dp(context, 3), 0, UIUtil.dp(context, 3));
                checkedTextView.setBackgroundResource(R.drawable.selector_filter_grid);
                checkedTextView.setGravity(Gravity.CENTER);
            }
        };


        mTopGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
    }

    public void setTopGridData(List<FilterType> list) {
        if (CommonUtil.isEmpty(list)) {
            return;
        }

        mTopAdapter.setList(list);
    }


    public void setBottomGridList(List<FilterType> list) {
        if (CommonUtil.isEmpty(list)) {
            return;
        }

        mBottomAdapter.setList(list);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_confirm:
                int topPosition = mTopGrid.getCheckedItemPosition();
                topPosition = topPosition == -1 ? 0 : topPosition;

                int bottomPosition = mBottomGrid.getCheckedItemPosition();
                bottomPosition = bottomPosition == -1 ? 0 : bottomPosition;

                FilterType financePhase = mTopAdapter.getItem(topPosition);
                FilterType area = mBottomAdapter.getItem(bottomPosition);

                FilterUrl.get().gridTop = financePhase.value;
                FilterUrl.get().gridBottom = area.value;

                if (onFilterDoneListener != null) {
                    onFilterDoneListener.onFilterDone(0, "", "");
                }

                break;
        }
    }

    private OnFilterDoneListener onFilterDoneListener;

    public void setOnFilterDoneListener(OnFilterDoneListener listener) {
        onFilterDoneListener = listener;
    }
}
