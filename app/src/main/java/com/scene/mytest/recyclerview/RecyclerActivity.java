package com.scene.mytest.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scene.mylibrary.TestUtil;
import com.scene.mytest.ItemModel;
import com.scene.mytest.R;
import com.scene.mytest.recyclerview.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerActivity extends AppCompatActivity implements RecyclerAdapter.OnItemRemoveListner {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setOnItemRemoveListner(this);
        List<ItemModel> modelList = new ArrayList<ItemModel>();
        for (int i = 0; i < 10; i++) {
            ItemModel model = new ItemModel();
            model.setId(i);
            model.setTitle("数据：" + i);
            modelList.add(model);
        }
        adapter.add(modelList);
    }

    @OnClick(R.id.back)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            default:
                break;
        }
    }


    @Override
    public void onItemRemove(int position) {
        TestUtil.getInstance().showToast(RecyclerActivity.this, "移除的数据是：第" + position + "条");
        adapter.remove(position);
    }
}
