##DropDownMenu
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-DropDownMenu-green.svg?style=true)](https://android-arsenal.com/details/1/3803)



筛选器. 尽管之前有很多人写,站在别人基础上重新写了一版,适配各种数据model.
现在的代码已经很清晰明了,模块分明.

##特点
1. 使用 Adapter模式 添加筛选器条目.使代码清晰可见,便于维护.
2. 使用泛型支持各种数据数据model. 提供三种泛型View类, 单列ListView,双列ListView 和 单个GridView, sample中还提供了两个GridView的示例.
3. 自己写FilterCheckedView,支持checked属性,使用selector就可配置选中样式.配合AbsListView.setChecked()使用
4. 使用FilterUrl作为中介,toString()方法获取到所拼接url,隔离了数据和View,使代码更清晰.

##ScreenShot
![DropDownMenu](images/dropDownMenu.gif "Gif Example")



##使用
布局文件
```
    <com.baiiu.filter.DropDownMenu
        android:id="@+id/filterDropDownView"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <TextView
            android:id="@id/mFilterContentView" //mFilterContentView标识为其内部内容,可换为RecyclerView等. id必填.
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center_vertical"
            android:textSize="22sp" />
    </com.baiiu.filter.DropDownMenu>
```

代码中:
```java
    //代码中设置Adapter.
    dropDownView.setMenuAdapter(new DropMenuAdapter(this, titleList));
```

DropMenuAdapter中:
```
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
        return 0;
    }

    @Override
    public View getView(int position, FrameLayout parentContainer) {
        ...
        return createSingleListView();
    }
```

添加SingleListView
```java 
    private View createSingleListView() {
        SingleListView<String> singleListView = new SingleListView<String>(mContext)
                .adapter(new SimpleTextAdapter<String>(null, mContext) {
                    @Override
                    public String provideText(String string) {
                        return string;
                    }
                })
                .onItemClick(new OnFilterItemClickListener<String>() {
                    @Override
                    public void onItemClick(String item) {
                        FilterUrl.instance().singleListPosition = item;
    
                        FilterUrl.instance().position = 0;
                        FilterUrl.instance().positionTitle = item;
    
                        if (onFilterDoneListener != null) {
                            onFilterDoneListener.onFilterDone(0, "", "");
                        }
                    }
                });
                
        //初始化数据
        singleListView.setList(list, -1);//默认不选中
    }
```


## License
    Copyright (C) 2016 zhe zhu

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.




