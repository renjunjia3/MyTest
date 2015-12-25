package com.scene.mytest.recyclerview.adapter;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.scene.mytest.R;
import com.scene.mytest.recyclerview.base.RecyclerViewHolderBase;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RecyclerViewHolder extends RecyclerViewHolderBase {
    @Bind(R.id.info_text)
    TextView infoText;
//    @Bind(R.id.card_view)
//    CardView cardView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


}