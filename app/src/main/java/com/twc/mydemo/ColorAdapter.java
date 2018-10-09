package com.twc.mydemo;

import android.app.Activity;
import android.view.View;

import com.eelly.sellerbuyer.ui.adapter.CommonRecylerAdapter;
import com.eelly.sellerbuyer.ui.adapter.ViewHolders;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends CommonRecylerAdapter<ColorInfo> {
    private ColorSelectListener listener;

    public interface ColorSelectListener {
        void getColorDatas();
    }

    private List<ColorInfo> colorInfoList = new ArrayList<>();

    public ColorAdapter(Activity mFragment, List<ColorInfo> datas) {
        super(R.layout.item_colorselect, mFragment, datas);
    }

    @Override
    protected void convert(ViewHolders holder, final int position, View convertView, final ColorInfo data) {
        if (data == null) {
            return;
        }
        holder.setText(R.id.colormsg, data.getColor());
        holder.displayImage(R.id.image, "", data.getColorId());
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.getIsSelect() == 1) {
                    data.setIsSelect(0);
                } else if (data.getIsSelect() == 0) {
                    data.setIsSelect(1);
                }
                notifyItemChanged(position);
            }
        }, R.id.linecolor);
        if (data.getIsSelect() == 1) {

        } else {

        }


    }
}
