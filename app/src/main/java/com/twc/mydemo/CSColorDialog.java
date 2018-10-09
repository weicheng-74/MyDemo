package com.twc.mydemo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class CSColorDialog extends DialogFragment {
    private int textId;
    private RecyclerView recyclerView;
    private ColorAdapter colorAdapter;
    private TextView textmsg;
    private CodesNumAdapter codesNumAdapter;
    List<ColorInfo> datas = new ArrayList<>();
    ArrayList<CodesInfo> codesInfos = new ArrayList<>();

    public static CSColorDialog newInstance(int codesnum) {
        Bundle args = new Bundle();
        args.putInt("codesnum", codesnum);
        CSColorDialog fragment = new CSColorDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textId = getArguments().getInt("codesnum");
    }

    @Override
    public void onStart() {
        super.onStart();
        // 设置宽度为屏宽, 靠近屏幕底部。
        Window win = getDialog().getWindow();
        // 一定要设置Background，如果不设置，window属性设置无效
        win.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00ffffff")));

        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

        WindowManager.LayoutParams params = win.getAttributes();
        params.gravity = Gravity.BOTTOM;
        // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        win.setAttributes(params);
    }

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_color, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        textmsg = (TextView) view.findViewById(R.id.textmsg);
        datas.add(new ColorInfo("红色", Color.RED));
        datas.add(new ColorInfo("红色", Color.RED));
        datas.add(new ColorInfo("红色", Color.RED));
        datas.add(new ColorInfo("红色", Color.RED));
        datas.add(new ColorInfo("红色", Color.RED));
        datas.add(new ColorInfo("红色", Color.RED));
        datas.add(new ColorInfo("红色", Color.RED));
        datas.add(new ColorInfo("红色", Color.RED));
        datas.add(new ColorInfo("红色", Color.RED));
        Log.e("textId", textId + "--->");

        codesInfos.add(new CodesInfo(0));
        codesInfos.add(new CodesInfo(0));
        codesInfos.add(new CodesInfo(0));
        codesInfos.add(new CodesInfo(0));
        codesInfos.add(new CodesInfo(0));
        codesInfos.add(new CodesInfo(0));
        codesInfos.add(new CodesInfo(0));
        codesInfos.add(new CodesInfo(0));
        codesInfos.add(new CodesInfo(0));

        switch (textId) {
            case 1:
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 6));
//                colorAdapter = new ColorAdapter(getActivity(), datas);
                recyclerView.setHasFixedSize(true);
//                recyclerView.setAdapter(colorAdapter);
                break;
            case 2:
                textmsg.setText("添加码数");
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
                codesNumAdapter = new CodesNumAdapter(getActivity(), codesInfos);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(codesNumAdapter);
                break;
        }
        return view;
    }
}
