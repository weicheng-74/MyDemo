package com.twc.mydemo;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * R.layout.item_codesnum
 */
public class CodesNumAdapter extends RecyclerView.Adapter<CodesNumAdapter.ViewHolder> {
    private int TYPE_LAST = 2;
    private int TYPE_EDIT = 1;
    private int TYPE_COMMAND = 0;
    private List<CodesInfo> codesInfoList = new ArrayList<>();
    private Context context;

    public CodesNumAdapter(FragmentActivity activity, ArrayList<CodesInfo> codesInfos) {
        this.context = activity;
        this.codesInfoList = codesInfos;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return TYPE_LAST;
        } else {
            return TYPE_COMMAND;
        }
    }

    public class LastViewHolder extends ViewHolder {

        public LastViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class CommandViewHolder extends ViewHolder {
        SelectCodesView selectCodesView;

        public CommandViewHolder(View itemView) {
            super(itemView);
            selectCodesView = (SelectCodesView) itemView.findViewById(R.id.selctview);

        }
    }

    public class AddViewHolder extends ViewHolder {
        public AddViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public CodesNumAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_LAST) {
            return new LastViewHolder
                    (LayoutInflater.from(context).inflate(R.layout.item_lastadd, parent, false));
        } else {
            return new CommandViewHolder
                    (LayoutInflater.from(context).inflate(R.layout.item_codesnum, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(CodesNumAdapter.ViewHolder holder, final int position) {
        if (holder instanceof CommandViewHolder) {
            CommandViewHolder commandViewHolder = (CommandViewHolder) holder;
            if (codesInfoList.get(position).getIsSelect() == 1) {
                commandViewHolder.selectCodesView.setSelectBg(1);
            } else if (codesInfoList.get(position).getIsSelect() == 0) {
                commandViewHolder.selectCodesView.setSelectBg(0);
            }
            commandViewHolder.selectCodesView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (codesInfoList.get(position).getIsSelect() == 1) {
                        codesInfoList.get(position).setIsSelect(0);
                    } else if (codesInfoList.get(position).getIsSelect() == 0) {
                        codesInfoList.get(position).setIsSelect(1);
                    }
                    notifyItemChanged(position);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return codesInfoList.size() + 1;
    }
}
