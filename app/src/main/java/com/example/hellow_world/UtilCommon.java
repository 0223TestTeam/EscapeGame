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

    private  float scaleX=0,scaleY=0;

    public boolean flag1=false,
            flag2 = false,
            flag3 = false,
            flag4 = false,
            flag5 = false,
            flag6 = false;


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
        flag1 = false;
        flag2 = false;
        flag3 = false;
        flag4 = false;
        flag5 = false;
        flag6 = false;
        scaleX=0;
        scaleY=0;
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

    public void setFlag6(boolean bool) {
        Log.d(TAG, "setFlag6");
        flag6 = bool;
    }

    public void setScaleX(float scale){
        Log.d(TAG, "seScaleX");
        scaleX=scale;
    }
    public void setScaleY(float scale){
        Log.d(TAG, "seScaleY");
        scaleY=scale;
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

    public boolean getFlag6() {
        Log.d(TAG, "getFlag6");
        return flag6;
    }

    public float getScaleX() {
        Log.d(TAG, "getScalX");
        return scaleX;
    }

    public  float getScaleY(){
        Log.d(TAG, "getScaleY");
        return scaleY;
    }
}