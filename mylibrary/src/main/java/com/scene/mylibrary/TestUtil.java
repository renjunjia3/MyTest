package com.scene.mylibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 15/12/07.
 */
public class TestUtil {
    private static TestUtil mTestUtil;
    private Toast mToast;

    public static TestUtil getInstance() {
        if (mTestUtil == null) {
            mTestUtil = new TestUtil();
        }
        return mTestUtil;
    }

    public void showToast(Context mContext, String msg) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
        mToast.show();
    }

}
