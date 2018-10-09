package com.twc.mydemo;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SelectCodesView extends LinearLayout {
    @Bind(R.id.msg)
    TextView msg;
    private Context context;
    private View view;
    private int select;
    @Bind(R.id.textline)
    LinearLayout textline;
    @Bind(R.id.edittext)
    EditText edittext;

    public SelectCodesView(Context context) {
        this(context, null);
    }

    public SelectCodesView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SelectCodesView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.item_singlecodes, this);
        ButterKnife.bind(this, view);
    }

    //切换是否选中背景。
    public void setSelectBg(int select) {
        this.select = select;
        if (select == 1) {
            msg.setTextColor(Color.BLUE);
        } else {
            msg.setTextColor(Color.BLACK);

        }
    }

    public interface ViewListener {
        void onClick();

    }
}
