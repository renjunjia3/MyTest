package com.scene.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.scene.mylibrary.TestUtil;
import com.scene.mytest.recyclerview.RecyclerActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        TestUtil.getInstance().showToast(MainActivity.this, "调用的是Library");
        initView();
    }

    private void initView() {
    }

    @OnClick({R.id.next, R.id.btn2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next:
                startActivity(new Intent(MainActivity.this, AddMoreActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(MainActivity.this, RecyclerActivity.class));
                break;
            default:
                break;
        }
    }


}
