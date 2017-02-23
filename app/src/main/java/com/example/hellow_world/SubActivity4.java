package com.example.hellow_world;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ServoRobo on 2017/02/23.
 */

public class SubActivity4 extends Activity {

    int[] state = new int[3];
    boolean end = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        // 現在のintentを取得する
        Intent intent = getIntent();
        // intentから指定キーの数字列を取得する
        intent.getIntArrayExtra("state");
    }

    public void back(View v){
        Intent intent = new Intent();
        intent.putExtra("state",state);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Touchivemnt", "X:" + event.getX() + ",Y:" + event.getY());
        if(end==true){
            Intent intent = new Intent(getApplication(),EndActivity.class);
            startActivityForResult(intent , 1003);
        }
        return true;
    }
}