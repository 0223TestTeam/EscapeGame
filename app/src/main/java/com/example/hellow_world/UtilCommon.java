package com.example.hellow_world;

/**
 * Created by primenote on 2017/05/14.
 */

import android.app.Application;
import android.util.Log;

/**
 * グローバル変数を扱うクラス
 * Created by sample on 2016/11/18.
 */
public class UtilCommon extends Application {

    private static final String TAG = "UtilCommon";
    private boolean mGlobal;  // boolean型のグローバル変数

    private boolean flag1=false,
            flag2 = false,
            flag3 = false,
            flag4 = false,
            flag5 = false;

    /**
     * アプリケーションの起動時に呼び出される
     */
    @Override
    public void onCreate() {

    }

    /**
     * アプリケーション終了時に呼び出される
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "onTerminate");
        flag1=false;
        flag2=false;
        flag3=false;
        flag4=false;
        flag5=false;
    }
    

    public void setFlag1(boolean bool) {
        Log.d(TAG, "setFlag1");
        flag1 = bool;
    }

    public void setFlag2(boolean bool) {
        Log.d(TAG, "setFlag2");
        flag2 = bool;
    }

    public void setFlag3(boolean bool) {
        Log.d(TAG, "setFlag3");
        flag3 = bool;
    }

    public void setFlag4(boolean bool) {
        Log.d(TAG, "setFlag4");
        flag4 = bool;
    }

    public void setFlag5(boolean bool) {
        Log.d(TAG, "setFlag5");
        flag5 = bool;
    }

    /**
     * グローバル変数の値を取得
     * @return グローバル変数（mGlobal）
     */
    public boolean getFlag1() {
        Log.d(TAG, "getFlag1");
        return flag1;
    }

    public boolean getFlag2() {
        Log.d(TAG, "getFlag2");
        return flag2;
    }

    public boolean getFlag3() {
        Log.d(TAG, "getFlag3");
        return flag3;
    }

    public boolean getFlag4() {
        Log.d(TAG, "getFlag4");
        return flag4;
    }

    public boolean getFlag5() {
        Log.d(TAG, "getFlag5");
        return flag5;
    }

}