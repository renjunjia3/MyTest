package com.scene.mytest.recyclerview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.scene.mytest.ItemModel;
import com.scene.mytest.R;
import com.scene.mytest.recyclerview.base.RecyclerViewBaseAdapter;
import com.scene.mytest.recyclerview.base.RecyclerViewHolderBase;

import java.util.List;

/**
 * Created by Administrator on 15/12/08.
 */
public class RecyclerAdapter extends RecyclerViewBaseAdapter<ItemModel> {
    private Context mContext;
    private OnItemRemoveListner mOnItemRemoveListner;

    public void setOnItemRemoveListner(OnItemRemoveListner mOnItemRemoveListner) {
        this.mOnItemRemoveListner = mOnItemRemoveListner;
    }

    @Override
    public void showData(RecyclerViewHolderBase viewHolder, final int position, List<ItemModel> mLists) {
        RecyclerViewHolder holder = (RecyclerViewHolder) viewHolder;
        holder.infoText.setText(mLists.get(position).getTitle());
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mOnItemRemoveListner.onItemRemove(position);
//            }
//        });
    }

    @Override
    public View createView(ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();
        //加载item的布局
        View view = View.inflate(mContext, R.layout.sample_item_text, null);
        return view;
    }

    @Override
    public RecyclerViewHolderBase createViewHolder(View view) {
        //直接返回viewholder对象
        return new RecyclerViewHolder(view);
    }


    public interface OnItemRemoveListner {
        void onItemRemove(int position);
    }

}
