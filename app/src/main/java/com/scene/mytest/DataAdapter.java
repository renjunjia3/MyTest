package com.scene.mytest;

import android.content.Context;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cundong.recyclerview.RecyclerViewUtils;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter {

    private LayoutInflater mLayoutInflater;
    private SortedList<ItemModel> mSortedList;
    private Context mContext;
    private RecyclerView mRecyclerView;


    public DataAdapter(Context context, RecyclerView mRecyclerView) {
        this.mContext = context;
        this.mRecyclerView = mRecyclerView;
        mLayoutInflater = LayoutInflater.from(context);
        mSortedList = new SortedList<>(ItemModel.class, new SortedList.Callback<ItemModel>() {


            /**
             * 返回一个负整数（第一个参数小于第二个）、零（相等）或正整数（第一个参数大于第二个）
             */
            @Override
            public int compare(ItemModel o1, ItemModel o2) {

                if (o1.id < o2.id) {
                    return -1;
                } else if (o1.id > o2.id) {
                    return 1;
                }

                return 0;
            }

            @Override
            public boolean areContentsTheSame(ItemModel oldItem, ItemModel newItem) {
                return oldItem.title.equals(newItem.title);
            }

            @Override
            public boolean areItemsTheSame(ItemModel item1, ItemModel item2) {
                return item1.id == item2.id;
            }

            @Override
            public void onInserted(int position, int count) {
                notifyItemRangeInserted(position, count);
            }

            @Override
            public void onRemoved(int position, int count) {
                notifyItemRangeRemoved(position, count);
            }

            @Override
            public void onMoved(int fromPosition, int toPosition) {
                notifyItemMoved(fromPosition, toPosition);
            }

            @Override
            public void onChanged(int position, int count) {
                notifyItemRangeChanged(position, count);
            }
        });
    }

    public void addItems(ArrayList<ItemModel> list) {
        mSortedList.beginBatchedUpdates();

        for (ItemModel itemModel : list) {
            mSortedList.add(itemModel);
        }

        mSortedList.endBatchedUpdates();
    }

    public void deleteItems(ArrayList<ItemModel> items) {
        mSortedList.beginBatchedUpdates();
        for (ItemModel item : items) {
            mSortedList.remove(item);
        }
        mSortedList.endBatchedUpdates();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.sample_item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ItemModel item = mSortedList.get(position);

        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.textView.setText(item.title);
    }

    @Override
    public int getItemCount() {
        return mSortedList.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.info_text);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ItemModel item = mSortedList.get(RecyclerViewUtils.getAdapterPosition(mRecyclerView, ViewHolder.this));
                    Toast.makeText(mContext, item.title, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}