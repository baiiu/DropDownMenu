package com.baiiu.filterdropdownmenu;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.baiiu.filter.filter.adapter.MenuAdapter;
import com.baiiu.filter.filter.adapter.SubMenuAdapter;
import com.baiiu.filter.filter.interfaces.OnFilterDoneListener;
import com.baiiu.filter.filter.typeview.DoubleListView;
import com.baiiu.filter.filter.typeview.SingleListView;
import com.baiiu.filter.filter.util.CommonUtil;
import com.baiiu.filter.filter.util.UIUtil;
import com.baiiu.filter.filter.view.FilterCheckedTextView;
import com.baiiu.filterdropdownmenu.entity.FilterType;
import com.baiiu.filterdropdownmenu.entity.FilterUrl;

import java.util.List;

/**
 * author: baiiu
 * date: on 16/1/17 21:14
 * description:
 */
public class FilterMenuAdapter implements MenuAdapter {
    private final Context mContext;
    private OnFilterDoneListener onFilterDoneListener;
    private String[] titles;

    public FilterMenuAdapter(Context context, String[] titles, OnFilterDoneListener onFilterDoneListener) {
        this.mContext = context;
        this.titles = titles;
        this.onFilterDoneListener = onFilterDoneListener;
    }

    @Override
    public int getMenuCount() {
        return titles.length;
    }

    @Override
    public String getMenuTitle(int position) {
        return titles[position];
    }

    @Override
    public int getBottomMargin(int position) {
        if (position == 3) {
            return 0;
        }

        return UIUtil.dp(mContext, 140);
    }

    @Override
    public View getView(int position, FrameLayout parentContainer) {
        View view = parentContainer.getChildAt(position);

        if (view != null) {
            return view;
        }

        switch (position) {
            case 0:
                view = comTypeDoubleListView();
                break;
            case 1:
                view = createSortType();
                break;
            case 2:
                view = industryDoubleListView();
                break;
            case 3:
                view = createDoubleGrid();
                break;
        }

        return view;
    }


    private View comTypeDoubleListView() {
        DoubleListView<FilterType, FilterType> comTypeDoubleListView = new DoubleListView<FilterType, FilterType>(mContext)
                .leftAdapter(new SubMenuAdapter<FilterType>(null, mContext) {
                    @Override
                    public String provideText(FilterType filterType) {
                        return filterType.desc;
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        checkedTextView.setPadding(UIUtil.dp(mContext, 44), UIUtil.dp(mContext, 15), 0, UIUtil.dp(mContext, 15));
                    }
                })
                .rightAdapter(new SubMenuAdapter<FilterType>(null, mContext) {
                    @Override
                    public String provideText(FilterType filterType) {
                        return filterType.desc;
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        checkedTextView.setPadding(UIUtil.dp(mContext, 30), UIUtil.dp(mContext, 15), 0, UIUtil.dp(mContext, 15));
                        checkedTextView.setBackgroundResource(android.R.color.white);
                    }
                })
                .onLeftItemClickListener(new DoubleListView.OnLeftItemClickListener<FilterType, FilterType>() {
                    @Override
                    public List<FilterType> provideRightList(FilterType item, int position) {
                        List<FilterType> child = item.child;
                        if (CommonUtil.isEmpty(child)) {
                            FilterUrl.get().position0Left = item.desc;
                            FilterUrl.get().position = 0;
                            FilterUrl.get().positionTitle = item.desc;

                            onFilterDone();
                        }

                        return child;
                    }
                })
                .onRightItemClickListener(new DoubleListView.OnRightItemClickListener<FilterType, FilterType>() {
                    @Override
                    public void onRightItemClick(FilterType item, FilterType childItem) {
                        FilterUrl.get().position0Right = childItem.value;

                        FilterUrl.get().position = 0;
                        FilterUrl.get().positionTitle = childItem.desc;

                        onFilterDone();
                    }
                });


        comTypeDoubleListView.setLeftList(comType, 0);

        return comTypeDoubleListView;
    }


    private View industryDoubleListView() {
        DoubleListView<FilterType, FilterType> industryDoubleListView = new DoubleListView<FilterType, FilterType>(mContext)
                .leftAdapter(new SubMenuAdapter<FilterType>(null, mContext) {
                    @Override
                    public String provideText(FilterType filterType) {
                        return filterType.desc;
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        checkedTextView.setPadding(UIUtil.dp(mContext, 44), UIUtil.dp(mContext, 15), 0, UIUtil.dp(mContext, 15));
                    }
                })
                .rightAdapter(new SubMenuAdapter<FilterType>(null, mContext) {
                    @Override
                    public String provideText(FilterType filterType) {
                        return filterType.desc;
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        checkedTextView.setPadding(UIUtil.dp(mContext, 30), UIUtil.dp(mContext, 15), 0, UIUtil.dp(mContext, 15));
                        checkedTextView.setBackgroundResource(android.R.color.white);
                    }
                })
                .onLeftItemClickListener(new DoubleListView.OnLeftItemClickListener<FilterType, FilterType>() {
                    @Override
                    public List<FilterType> provideRightList(FilterType item, int position) {
                        List<FilterType> child = item.child;
                        if (CommonUtil.isEmpty(child)) {//无二级菜单
                            FilterUrl.get().industry = "";
                            FilterUrl.get().tag = "";
                            FilterUrl.get().position = 2;
                            FilterUrl.get().positionTitle = item.desc;

                            onFilterDone();
                        }
                        return child;
                    }
                })
                .onRightItemClickListener(new DoubleListView.OnRightItemClickListener<FilterType, FilterType>() {
                    @Override
                    public void onRightItemClick(FilterType item, FilterType childItem) {
                        FilterUrl.get().industry = item.value;
                        FilterUrl.get().tag = childItem.value;
                        String desc = childItem.desc;

                        if ("全部".equals(desc)) {
                            FilterUrl.get().positionTitle = item.desc;
                        } else {
                            FilterUrl.get().positionTitle = childItem.desc;
                        }
                        FilterUrl.get().position = 2;

                        onFilterDone();
                    }
                });

        industryDoubleListView.setLeftList(industry, 0);

        return industryDoubleListView;
    }


    private View createSortType() {
        SingleListView<FilterType> singleListView = new SingleListView<FilterType>(mContext)
                .adapter(new SubMenuAdapter<FilterType>(null, mContext) {
                    @Override
                    public String provideText(FilterType filterType) {
                        return filterType.desc;
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        int dp = UIUtil.dp(mContext, 15);
                        checkedTextView.setPadding(dp, dp, 0, dp);
                    }
                })
                .onItemClick(new SingleListView.OnItemClickListener<FilterType>() {
                    @Override
                    public void onItemClick(FilterType item) {
                        FilterUrl.get().position = 1;
                        FilterUrl.get().positionTitle = item.desc;
                        FilterUrl.get().sortType = item.value;

                        onFilterDone();
                    }
                });

        singleListView.setList(sortType, 0);

        return singleListView;
    }

    //=======================================================================
    private View createDoubleGrid() {
        DoubleGridView doubleGridView = new DoubleGridView(mContext);
        doubleGridView.setOnFilterDoneListener(onFilterDoneListener);

        doubleGridView.setTopGridData(phases);

        doubleGridView.setBottomGridList(areas);

        return doubleGridView;
    }


    private void onFilterDone() {
        if (onFilterDoneListener != null) {
            onFilterDoneListener.onFilterDone(0, "", "");
        }
    }

}
