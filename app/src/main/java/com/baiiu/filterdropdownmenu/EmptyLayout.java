package com.baiiu.filterdropdownmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by baiiu on 15/11/30.
 * <p/>
 * Loading
 * Error
 * Empty
 */
public class EmptyLayout extends FrameLayout {
    public static final int STATE_HASDATA = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_EMPTY = 2;
    public static final int STATE_ERROR = 3;
    private int mState = -1;

    @Bind(R.id.rl_emtpy)
    FrameLayout emtpyView;

    @Bind(R.id.tv_empty)
    TextView tv_empty;


    @Bind(R.id.rl_loading)
    FrameLayout loadingView;

    @Bind(R.id.tv_loading)
    TextView tv_loading;

    @Bind(R.id.rl_error)
    FrameLayout errorView;

    @Bind(R.id.tv_error)
    TextView tv_error;


    private Context context;

    public EmptyLayout(Context context) {
        this(context, null);
    }

    public EmptyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public EmptyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        View view = inflate(context, R.layout.layout_empty, this);
        ButterKnife.bind(this, view);
    }


    public void setState(int state) {
        if (state == mState) {
            return;
        }

        this.mState = state;

        if (mState == STATE_HASDATA) {
            setVisibility(GONE);
            return;
        }

        setVisibility(View.VISIBLE);
        emtpyView.setVisibility(mState == STATE_EMPTY ? VISIBLE : INVISIBLE);
        loadingView.setVisibility(mState == STATE_LOADING ? VISIBLE : INVISIBLE);
        errorView.setVisibility(mState == STATE_ERROR ? VISIBLE : INVISIBLE);
    }

}
