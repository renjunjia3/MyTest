package com.scene.mytest;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.scene.mylibrary.SecondActivity;
import com.scene.mylibrary.TestUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        TestUtil.getInstance().showToast(MainActivity.this, "调用的是Library");
    }

    @OnClick(R.id.next)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next:
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
            default:
                break;
        }
    }

}
